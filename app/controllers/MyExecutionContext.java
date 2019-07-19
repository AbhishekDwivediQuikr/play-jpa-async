package controllers;

import akka.actor.ActorSystem;
import play.api.libs.concurrent.CustomExecutionContext;
import scala.concurrent.ExecutionContext;

import javax.inject.Inject;

public class MyExecutionContext extends CustomExecutionContext {

    @Inject
    public MyExecutionContext(ActorSystem actorSystem) {
        // uses a custom thread pool defined in application.conf
        super(actorSystem, "play.akka.actor.contexts.my-dispatcher");
    }



}

