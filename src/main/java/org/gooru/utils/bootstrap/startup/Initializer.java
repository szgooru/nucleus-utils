package org.gooru.utils.bootstrap.startup;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

public interface Initializer {
  void initializeComponent(Vertx vertx, JsonObject config);

}
