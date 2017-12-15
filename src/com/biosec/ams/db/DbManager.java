// 
// Decompiled by Procyon v0.5.30
// 

package com.biosec.ams.db;

import java.util.Calendar;
import java.text.DateFormat;
import com.biosec.ams.dao.Activationlog;
import com.biosec.ams.dao.Etc;
import javax.persistence.Query;
import java.sql.DriverManager;
import java.sql.Connection;
import com.biosec.ams.dao.Paramt;
import javax.persistence.EntityTransaction;
import java.sql.Timestamp;
import java.util.Date;
import com.biosec.ams.dao.Pushlog;
import java.util.List;
import com.biosec.ams.dao.Users;
import com.biosec.ams.dao.LoginMessage;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;

public class DbManager
{
    public static void main(final String[] args) {
        try {
            final EntityManager em = new DbManager().em();
            em.getTransaction().begin();
            final int update = em.createQuery("update Users u set u.password='nimc' where lower(u.username)='admin'").executeUpdate();
            em.getTransaction().commit();
            System.out.println("update success " + update);
        }
        catch (Exception no) {
            no.printStackTrace();
        }
    }
    
    public EntityManager em() {
        return Persistence.createEntityManagerFactory("CardManagementSolutionPU").createEntityManager();
    }
    
    public LoginMessage passwordChange(final EntityManager em, final String username, final String passwd, final String npassword) {
        final LoginMessage lm = new LoginMessage();
        try {
            em.getTransaction().begin();
            final int update = em.createQuery("update Users u set u.password=?1 where u.username=?2 and u.password=?3").setParameter(1, (Object)npassword).setParameter(2, (Object)username).setParameter(3, (Object)passwd).executeUpdate();
            em.getTransaction().commit();
            if (update > 0) {
                lm.setMessage("success");
                return lm;
            }
            lm.setMessage("Invalid Logged In username");
            return lm;
        }
        catch (Exception e) {
            e.printStackTrace();
            lm.setMessage(e.getMessage());
            em.getTransaction().rollback();
            return lm;
        }
    }
    
    public Users getUser(final EntityManager em, final String username) {
        try {
            final Users u = (Users)em.find((Class)Users.class, (Object)username);
            return u;
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public List<String> getUnprocessedChipID(final EntityManager em) {
        return (List<String>)em.createQuery("select distinct(e.chipid) from Pushlog e where e.status=-1").getResultList();
    }
    
    public void addPushLog(final EntityManager em, final String chipid) {
        try {
            final Pushlog p = new Pushlog();
            Object o = em.createQuery("select max(p.id) from Pushlog p").getSingleResult();
            if (o == null) {
                o = 1;
            }
            int idx = Integer.parseInt(o.toString());
            ++idx;
            p.setChipid(chipid);
            p.setId(idx);
            p.setStatus(Short.parseShort("-1"));
            p.setTs(new Timestamp(new Date().getTime()));
            em.getTransaction().begin();
            em.persist((Object)p);
            em.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
    
    public void updatePushLog(final EntityManager em, final String chipid) {
        final EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            final int x = em.createQuery("update Pushlog p set p.status=0 where p.chipid=?1").setParameter(1, (Object)chipid).executeUpdate();
            trans.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        }
    }
    
    public Paramt getID(final EntityManager em) {
        final EntityTransaction trans = em.getTransaction();
        try {
            final Paramt p = (Paramt)em.createQuery("select p from Paramt p  where  p.id=1 ").getSingleResult();
            return p;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void updateID(final EntityManager em, final String centerid, final String centername, final String sysid) {
        final EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            final int x = em.createQuery("update Paramt p set  p.centercode=?1,p.sysid=?2,p.centername  =?3 where p.id=1 ").setParameter(1, (Object)centerid).setParameter(2, (Object)sysid).setParameter(3, (Object)centername).executeUpdate();
            trans.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
        }
    }
    
    public boolean updateUser(final EntityManager em, final String username, final String surname, final String firstname, final String email, final String phone, String accounttype, String status, final String passwd) {
        try {
            final Users uu = this.getUser(em, username);
            if (accounttype.equalsIgnoreCase("***")) {
                accounttype = uu.getAccesstype();
            }
            if (status.equalsIgnoreCase("***")) {
                status = uu.getStatus();
            }
            String pwd;
            if (passwd.equalsIgnoreCase("***")) {
                pwd = uu.getPassword();
            }
            else {
                pwd = passwd;
            }
            em.getTransaction().begin();
            final Users u = (Users)em.find((Class)Users.class, (Object)username);
            u.setAccesstype(accounttype);
            u.setFirstname(firstname);
            u.setEmail(email);
            u.setPhone(phone);
            u.setStatus(status);
            u.setSurname(surname);
            u.setPassword(pwd);
            em.getTransaction().commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        }
    }
    
    public static Connection getCnn2() {
        try {
            return DriverManager.getConnection("jdbc:derby:CMS?user=mbaocha&password=mbaocha");
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static Connection getCnn(final EntityManager em) {
        final EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            final Connection connection = (Connection)em.unwrap((Class)Connection.class);
            trans.commit();
            return connection;
        }
        catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            return null;
        }
    }
    
    public LoginMessage Login(final EntityManager em, final String username, final String passwd) {
        final LoginMessage lm = new LoginMessage();
        try {
            final Query qr = em.createQuery("Select e from Users e where e.username=?1 and e.password=?2").setParameter(1, (Object)username.toLowerCase()).setParameter(2, (Object)passwd);
            final List<?> ls = (List<?>)qr.getResultList();
            if (ls.size() < 1) {
                lm.setMessage("Invalid username and/or password ");
                return lm;
            }
            final Users us = (Users)ls.get(0);
            if (us.getStatus().equalsIgnoreCase("inactive")) {
                lm.setMessage("Account Inactive");
                return lm;
            }
            lm.setMessage("success");
            lm.setUsers(us);
            return lm;
        }
        catch (Exception e) {
            e.printStackTrace();
            lm.setMessage(e.getMessage());
            return lm;
        }
    }
    
    boolean IsUserUnique(final EntityManager em, final String username) {
        try {
            final List<?> l = (List<?>)em.createQuery("select e from Users e where e.username=?1").setParameter(1, (Object)username).getResultList();
            return l.size() <= 0;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void removeAdminPin(final EntityManager em, final String chipid) {
        try {
            em.createQuery("delete from Etc e where e.chipid=?1").setParameter(1, (Object)chipid).executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    So getAdminPin(final EntityManager em, final String chipid) {
        final So so = new So();
        try {
            final List<Etc> l = (List<Etc>)em.createQuery("select e from Etc e where e.chipid=?1").setParameter(1, (Object)chipid).getResultList();
            if (l.size() < 1) {
                return null;
            }
            so.setP(l.get(0).getP());
            so.setS(l.get(0).getP());
            return so;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean insertPIN(final EntityManager em, final String chipd, final Long s, final Long p) {
        try {
            final Etc so = new Etc();
            so.setP(p);
            so.setS(s);
            so.setCid(chipd);
            em.getTransaction().begin();
            em.persist((Object)so);
            em.getTransaction().commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean createUser(final EntityManager em, final String username, final String passwd, final String surname, final String firstname, final String email, final String phone, final String nin, final String status, final String acctype) {
        try {
            final Users users = new Users();
            users.setUsername(username.toLowerCase());
            users.setSurname(surname);
            users.setStatus(status);
            users.setPhone(phone);
            users.setPassword(passwd);
            users.setNin(nin);
            users.setEmail(email);
            users.setFirstname(firstname);
            users.setAccesstype(acctype);
            users.setCreationtime(new Date());
            em.getTransaction().begin();
            em.persist((Object)users);
            em.getTransaction().commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    int getMaxLog(final EntityManager em) {
        final Integer o = (Integer)em.createQuery("select max(e.id) from Activationlog e").getSingleResult();
        return o;
    }
    
    public List<Activationlog> getLogs(final EntityManager em, final String username, final String from, final String to, String actiontype, String actionresult) {
        try {
            final DateFormat sdf = DateFormat.getDateInstance(2);
            final Date from_date = sdf.parse(from);
            Date to_date = sdf.parse(to);
            final Calendar beginCalendar = Calendar.getInstance();
            beginCalendar.setTime(to_date);
            beginCalendar.add(5, 1);
            to_date = beginCalendar.getTime();
            if (actiontype.equalsIgnoreCase("***")) {
                actiontype = "%";
            }
            if (actionresult.equalsIgnoreCase("***")) {
                actionresult = "%";
            }
            if (username.equalsIgnoreCase("***")) {
                return (List<Activationlog>)em.createQuery("SELECT e FROM Activationlog e  WHERE  ( e.ts BETWEEN ?1 AND ?2) and e.actiontype like '" + actiontype + "' and e.actionresult like '" + actionresult + "'").setParameter(1, (Object)new Timestamp(from_date.getTime())).setParameter(2, (Object)new Timestamp(to_date.getTime())).getResultList();
            }
            return (List<Activationlog>)em.createQuery("SELECT e FROM Activationlog e  WHERE e.username=?1 and ( e.ts BETWEEN ?2 AND ?3) and e.actiontype like '" + actiontype + "' and e.actionresult like '" + actionresult + "'").setParameter(1, (Object)username).setParameter(2, (Object)new Timestamp(from_date.getTime())).setParameter(3, (Object)new Timestamp(to_date.getTime())).getResultList();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean insertLogs(final EntityManager em, final String actiontype, final String chipid, final String actionresult, final String mocf, final String username, final String msg, final byte[] minutie) {
        try {
            final Activationlog al = new Activationlog();
            al.setActiontype(actiontype);
            al.setChipid(chipid);
            al.setId(this.getMaxLog(em) + 1);
            al.setActionresult(actionresult);
            al.setMocFinger(mocf);
            al.setTs(new Timestamp(new Date().getTime()));
            al.setUsername(username);
            al.setMessage(msg);
            al.setMinutie(minutie);
            em.getTransaction().begin();
            em.persist((Object)al);
            em.getTransaction().commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<Users> getUsers(final EntityManager em) {
        return (List<Users>)em.createQuery("SELECT e FROM Users e ").getResultList();
    }
}
