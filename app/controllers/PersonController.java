package controllers;

import Repository.EmpRepo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.JsonArray;

import models.Person;
import models.Vehicle;


import play.libs.Akka;
import play.libs.F;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;
import scala.concurrent.ExecutionContext;
import scala.concurrent.Promise;
import service.empservice;

import javax.inject.Inject;
import javax.persistence.*;
import java.beans.ExceptionListener;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import play.libs.concurrent.HttpExecution;

import javax.inject.Inject;
import java.util.concurrent.Executor;
import java.util.concurrent.CompletionStage;

import static java.util.concurrent.CompletableFuture.supplyAsync;


/**
 * The controller keeps all database operations behind the repository, and uses
 * {@link play.libs.concurrent.HttpExecutionContext} to provide access to the
 * {@link play.mvc.Http.Context} methods like {@code request()} and {@code flash()}.
 */
public class PersonController extends Controller {


    public Result index(final Http.Request request) {
        return ok(views.html.index.render(request));
    }

    private static final String PERSISTENCE_UNIT_NAME = "defaultPersistenceUnit";
    private static EntityManagerFactory factory;
    static final ObjectMapper objectMapper;
    private MyExecutionContext myExecutionContext;

    @Inject
    public PersonController(MyExecutionContext myExecutionContext) {
        this.myExecutionContext = myExecutionContext;
    }


    static {
        objectMapper = new ObjectMapper();
    }

    @Inject
    empservice service;


    public CompletionStage<Result> addPerson(final Http.Request request) throws Exception {

        JsonNode jsonNode = request.body().asJson();

        Executor myEc = HttpExecution.fromThread((Executor) myExecutionContext);
        return calculateResponse()
                .thenApplyAsync(
                        answer -> {
                            try {
                                //return ok(service.savePerson(jsonNode));
                                JsonNode node = service.savePerson(jsonNode);
                                return ok(node);
                            } catch (Exception e) {
                                return ok(e.getMessage());
                            }

                            // uses Http.Context

                        },
                        myEc);


    }

    public CompletionStage<Result> showPerson(Long id) throws Exception {

        Executor myEc = HttpExecution.fromThread((Executor) myExecutionContext);
        return calculateResponse()
                .thenApplyAsync(
                        answer -> {
                            try {
                                //return ok(service.savePerson(jsonNode));
                                JsonNode node = service.showPerson(id);
                                return ok(node);
                            } catch (Exception e) {
                                return ok(e.getMessage());
                            }

                            // uses Http.Context

                        },
                        myEc);
    }

    private static CompletionStage<String> calculateResponse() {
        return CompletableFuture.completedFuture(null);
    }

    public CompletionStage<Result> deletePerson(Long id) throws Exception {

        Executor myEc = HttpExecution.fromThread((Executor) myExecutionContext);

        return calculateResponse()
                .thenApplyAsync(
                        answer -> {
                            try {
                                //return ok(service.savePerson(jsonNode));
                                JsonNode node = service.deletePerson(id);
                                return ok(node);
                            } catch (Exception e) {
                                return ok(e.getMessage());
                            }


                        },
                        myEc);


    }

}
