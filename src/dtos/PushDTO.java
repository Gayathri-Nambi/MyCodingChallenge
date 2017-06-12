package dtos;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PushDTO {
	String	iden;
	Boolean	active;
	float	created;
	float	modified;
	String	type;
	Boolean	dismissed;
	String	guid;
	String	direction;
	String	senderIden;
	String	senderEmail;
	String	senderEmailNormalized;
	String	senderName;
	String	receiverIden;
	String	receiverEmail;
	String	receiverEmailNormalized;
	String	targetDeviceIden;
	String	sourceDeviceIden;
	String	clientIden;
	String	channelIden;
	String	awakeAppGuids;
	String	title;
	String	body;

	public String getIden() {
		return iden;
	}
	public void setIden(String iden) {
		this.iden = iden;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public float getCreated() {
		return created;
	}
	public void setCreated(float created) {
		this.created = created;
	}
	public float getModified() {
		return modified;
	}
	public void setModified(float modified) {
		this.modified = modified;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getDismissed() {
		return dismissed;
	}
	public void setDismissed(Boolean dismissed) {
		this.dismissed = dismissed;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getSenderIden() {
		return senderIden;
	}
	public void setSenderIden(String senderIden) {
		this.senderIden = senderIden;
	}
	public String getSenderEmail() {
		return senderEmail;
	}
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	public String getSenderEmailNormalized() {
		return senderEmailNormalized;
	}
	public void setSenderEmailNormalized(String senderEmailNormalized) {
		this.senderEmailNormalized = senderEmailNormalized;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getReceiverIden() {
		return receiverIden;
	}
	public void setReceiverIden(String receiverIden) {
		this.receiverIden = receiverIden;
	}
	public String getReceiverEmail() {
		return receiverEmail;
	}
	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}
	public String getReceiverEmailNormalized() {
		return receiverEmailNormalized;
	}
	public void setReceiverEmailNormalized(String receiverEmailNormalized) {
		this.receiverEmailNormalized = receiverEmailNormalized;
	}
	public String getTargetDeviceIden() {
		return targetDeviceIden;
	}
	public void setTargetDeviceIden(String targetDeviceIden) {
		this.targetDeviceIden = targetDeviceIden;
	}
	public String getSourceDeviceIden() {
		return sourceDeviceIden;
	}
	public void setSourceDeviceIden(String sourceDeviceIden) {
		this.sourceDeviceIden = sourceDeviceIden;
	}
	public String getClientIden() {
		return clientIden;
	}
	public void setClientIden(String clientIden) {
		this.clientIden = clientIden;
	}
	public String getChannelIden() {
		return channelIden;
	}
	public void setChannelIden(String channelIden) {
		this.channelIden = channelIden;
	}
	public String getAwakeAppGuids() {
		return awakeAppGuids;
	}
	public void setAwakeAppGuids(String awakeAppGuids) {
		this.awakeAppGuids = awakeAppGuids;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}
