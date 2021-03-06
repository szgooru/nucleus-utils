package org.gooru.nucleus.utils.processors.messageProcessor;

import io.vertx.core.MultiMap;
import io.vertx.core.eventbus.Message;
import io.vertx.core.json.JsonObject;

import org.gooru.nucleus.utils.constants.MessageConstants;


public class MessageContextHolder implements MessageContext {

  private final Message<Object> message;

  private final JsonObject data;

  public MessageContextHolder(Message<Object> message) {
    this.message = message;
    this.data = (JsonObject) message.body();
  }

  @Override
  public JsonObject requestBody() {
    return data.getJsonObject(MessageConstants.MSG_HTTP_BODY);
  }

  @Override
  public JsonObject requestParams() {
    return data.getJsonObject(MessageConstants.MSG_HTTP_PARAM);
  }

  @Override
  public MultiMap headers() {
    return message.headers();
  }

  @Override
  public String command() {
    return headers().get(MessageConstants.MSG_HEADER_OP);
  }
}
