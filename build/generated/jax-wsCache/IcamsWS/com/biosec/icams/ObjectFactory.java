
package com.biosec.icams;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.biosec.icams package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SendCardStatusFeedBack_QNAME = new QName("http://webservice.icams.biosec.com/", "sendCardStatusFeedBack");
    private final static QName _RequestCardBlock_QNAME = new QName("http://webservice.icams.biosec.com/", "requestCardBlock");
    private final static QName _RetrievePINSResponse_QNAME = new QName("http://webservice.icams.biosec.com/", "retrievePINSResponse");
    private final static QName _RequestCardSuspend_QNAME = new QName("http://webservice.icams.biosec.com/", "requestCardSuspend");
    private final static QName _GetCardDetails_QNAME = new QName("http://webservice.icams.biosec.com/", "getCardDetails");
    private final static QName _RetrievePINS_QNAME = new QName("http://webservice.icams.biosec.com/", "retrievePINS");
    private final static QName _RequestCardReinstate_QNAME = new QName("http://webservice.icams.biosec.com/", "requestCardReinstate");
    private final static QName _RequestCardReinstateResponse_QNAME = new QName("http://webservice.icams.biosec.com/", "requestCardReinstateResponse");
    private final static QName _Persist_QNAME = new QName("http://webservice.icams.biosec.com/", "persist");
    private final static QName _RequestCardSuspendResponse_QNAME = new QName("http://webservice.icams.biosec.com/", "requestCardSuspendResponse");
    private final static QName _RequestCardBlockResponse_QNAME = new QName("http://webservice.icams.biosec.com/", "requestCardBlockResponse");
    private final static QName _SendCardStatusFeedBackResponse_QNAME = new QName("http://webservice.icams.biosec.com/", "sendCardStatusFeedBackResponse");
    private final static QName _GetCardDetailsResponse_QNAME = new QName("http://webservice.icams.biosec.com/", "getCardDetailsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.biosec.icams
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RetrievePINS }
     * 
     */
    public RetrievePINS createRetrievePINS() {
        return new RetrievePINS();
    }

    /**
     * Create an instance of {@link GetCardDetails }
     * 
     */
    public GetCardDetails createGetCardDetails() {
        return new GetCardDetails();
    }

    /**
     * Create an instance of {@link RequestCardSuspend }
     * 
     */
    public RequestCardSuspend createRequestCardSuspend() {
        return new RequestCardSuspend();
    }

    /**
     * Create an instance of {@link RequestCardBlock }
     * 
     */
    public RequestCardBlock createRequestCardBlock() {
        return new RequestCardBlock();
    }

    /**
     * Create an instance of {@link RetrievePINSResponse }
     * 
     */
    public RetrievePINSResponse createRetrievePINSResponse() {
        return new RetrievePINSResponse();
    }

    /**
     * Create an instance of {@link SendCardStatusFeedBack }
     * 
     */
    public SendCardStatusFeedBack createSendCardStatusFeedBack() {
        return new SendCardStatusFeedBack();
    }

    /**
     * Create an instance of {@link GetCardDetailsResponse }
     * 
     */
    public GetCardDetailsResponse createGetCardDetailsResponse() {
        return new GetCardDetailsResponse();
    }

    /**
     * Create an instance of {@link RequestCardBlockResponse }
     * 
     */
    public RequestCardBlockResponse createRequestCardBlockResponse() {
        return new RequestCardBlockResponse();
    }

    /**
     * Create an instance of {@link SendCardStatusFeedBackResponse }
     * 
     */
    public SendCardStatusFeedBackResponse createSendCardStatusFeedBackResponse() {
        return new SendCardStatusFeedBackResponse();
    }

    /**
     * Create an instance of {@link RequestCardSuspendResponse }
     * 
     */
    public RequestCardSuspendResponse createRequestCardSuspendResponse() {
        return new RequestCardSuspendResponse();
    }

    /**
     * Create an instance of {@link RequestCardReinstate }
     * 
     */
    public RequestCardReinstate createRequestCardReinstate() {
        return new RequestCardReinstate();
    }

    /**
     * Create an instance of {@link RequestCardReinstateResponse }
     * 
     */
    public RequestCardReinstateResponse createRequestCardReinstateResponse() {
        return new RequestCardReinstateResponse();
    }

    /**
     * Create an instance of {@link Persist }
     * 
     */
    public Persist createPersist() {
        return new Persist();
    }

    /**
     * Create an instance of {@link CardStatusChangeFeedBackResponse }
     * 
     */
    public CardStatusChangeFeedBackResponse createCardStatusChangeFeedBackResponse() {
        return new CardStatusChangeFeedBackResponse();
    }

    /**
     * Create an instance of {@link RetrievePINResponse }
     * 
     */
    public RetrievePINResponse createRetrievePINResponse() {
        return new RetrievePINResponse();
    }

    /**
     * Create an instance of {@link RequestCardStatusChangeResponse }
     * 
     */
    public RequestCardStatusChangeResponse createRequestCardStatusChangeResponse() {
        return new RequestCardStatusChangeResponse();
    }

    /**
     * Create an instance of {@link CardDetails }
     * 
     */
    public CardDetails createCardDetails() {
        return new CardDetails();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendCardStatusFeedBack }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.icams.biosec.com/", name = "sendCardStatusFeedBack")
    public JAXBElement<SendCardStatusFeedBack> createSendCardStatusFeedBack(SendCardStatusFeedBack value) {
        return new JAXBElement<SendCardStatusFeedBack>(_SendCardStatusFeedBack_QNAME, SendCardStatusFeedBack.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestCardBlock }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.icams.biosec.com/", name = "requestCardBlock")
    public JAXBElement<RequestCardBlock> createRequestCardBlock(RequestCardBlock value) {
        return new JAXBElement<RequestCardBlock>(_RequestCardBlock_QNAME, RequestCardBlock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrievePINSResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.icams.biosec.com/", name = "retrievePINSResponse")
    public JAXBElement<RetrievePINSResponse> createRetrievePINSResponse(RetrievePINSResponse value) {
        return new JAXBElement<RetrievePINSResponse>(_RetrievePINSResponse_QNAME, RetrievePINSResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestCardSuspend }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.icams.biosec.com/", name = "requestCardSuspend")
    public JAXBElement<RequestCardSuspend> createRequestCardSuspend(RequestCardSuspend value) {
        return new JAXBElement<RequestCardSuspend>(_RequestCardSuspend_QNAME, RequestCardSuspend.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardDetails }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.icams.biosec.com/", name = "getCardDetails")
    public JAXBElement<GetCardDetails> createGetCardDetails(GetCardDetails value) {
        return new JAXBElement<GetCardDetails>(_GetCardDetails_QNAME, GetCardDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RetrievePINS }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.icams.biosec.com/", name = "retrievePINS")
    public JAXBElement<RetrievePINS> createRetrievePINS(RetrievePINS value) {
        return new JAXBElement<RetrievePINS>(_RetrievePINS_QNAME, RetrievePINS.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestCardReinstate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.icams.biosec.com/", name = "requestCardReinstate")
    public JAXBElement<RequestCardReinstate> createRequestCardReinstate(RequestCardReinstate value) {
        return new JAXBElement<RequestCardReinstate>(_RequestCardReinstate_QNAME, RequestCardReinstate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestCardReinstateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.icams.biosec.com/", name = "requestCardReinstateResponse")
    public JAXBElement<RequestCardReinstateResponse> createRequestCardReinstateResponse(RequestCardReinstateResponse value) {
        return new JAXBElement<RequestCardReinstateResponse>(_RequestCardReinstateResponse_QNAME, RequestCardReinstateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Persist }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.icams.biosec.com/", name = "persist")
    public JAXBElement<Persist> createPersist(Persist value) {
        return new JAXBElement<Persist>(_Persist_QNAME, Persist.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestCardSuspendResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.icams.biosec.com/", name = "requestCardSuspendResponse")
    public JAXBElement<RequestCardSuspendResponse> createRequestCardSuspendResponse(RequestCardSuspendResponse value) {
        return new JAXBElement<RequestCardSuspendResponse>(_RequestCardSuspendResponse_QNAME, RequestCardSuspendResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestCardBlockResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.icams.biosec.com/", name = "requestCardBlockResponse")
    public JAXBElement<RequestCardBlockResponse> createRequestCardBlockResponse(RequestCardBlockResponse value) {
        return new JAXBElement<RequestCardBlockResponse>(_RequestCardBlockResponse_QNAME, RequestCardBlockResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendCardStatusFeedBackResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.icams.biosec.com/", name = "sendCardStatusFeedBackResponse")
    public JAXBElement<SendCardStatusFeedBackResponse> createSendCardStatusFeedBackResponse(SendCardStatusFeedBackResponse value) {
        return new JAXBElement<SendCardStatusFeedBackResponse>(_SendCardStatusFeedBackResponse_QNAME, SendCardStatusFeedBackResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCardDetailsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.icams.biosec.com/", name = "getCardDetailsResponse")
    public JAXBElement<GetCardDetailsResponse> createGetCardDetailsResponse(GetCardDetailsResponse value) {
        return new JAXBElement<GetCardDetailsResponse>(_GetCardDetailsResponse_QNAME, GetCardDetailsResponse.class, null, value);
    }

}
