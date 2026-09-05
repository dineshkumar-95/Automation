package org.example.api.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmailLog {

    @JsonProperty("id")
    private String id;

    @JsonProperty("email_type")
    private String emailType;

    @JsonProperty("message_id")
    private String messageId;

    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("email")
    private String email;

    @JsonProperty("status")
    private String status;

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("delivery_status")
    private String deliveryStatus;

    @JsonProperty("created_at")
    private Long createdAt;

    @JsonProperty("updated_at")
    private Long updatedAt;

    @JsonProperty("bounce_reason")
    private String bounceReason;

    @JsonProperty("events")
    private List<Object> events; // Can be detailed further if necessary

    public String getId() { return id; }
    public EmailLog setId(String id) { this.id = id; return this; }

    public String getEmailType() { return emailType; }
    public EmailLog setEmailType(String emailType) { this.emailType = emailType; return this; }

    public String getMessageId() { return messageId; }
    public EmailLog setMessageId(String messageId) { this.messageId = messageId; return this; }

    public String getCustomerId() { return customerId; }
    public EmailLog setCustomerId(String customerId) { this.customerId = customerId; return this; }

    public String getEmail() { return email; }
    public EmailLog setEmail(String email) { this.email = email; return this; }

    public String getStatus() { return status; }
    public EmailLog setStatus(String status) { this.status = status; return this; }

    public String getSubject() { return subject; }
    public EmailLog setSubject(String subject) { this.subject = subject; return this; }

    public String getDeliveryStatus() { return deliveryStatus; }
    public EmailLog setDeliveryStatus(String deliveryStatus) { this.deliveryStatus = deliveryStatus; return this; }

    public Long getCreatedAt() { return createdAt; }
    public EmailLog setCreatedAt(Long createdAt) { this.createdAt = createdAt; return this; }

    public Long getUpdatedAt() { return updatedAt; }
    public EmailLog setUpdatedAt(Long updatedAt) { this.updatedAt = updatedAt; return this; }

    public String getBounceReason() { return bounceReason; }
    public EmailLog setBounceReason(String bounceReason) { this.bounceReason = bounceReason; return this; }

    public List<Object> getEvents() { return events; }
    public EmailLog setEvents(List<Object> events) { this.events = events; return this; }
}
