// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/abhishekkumardwivedi/Documents/play-samples-play-java-jpa-example/conf/routes
// @DATE:Fri Jul 19 15:23:17 IST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  PersonController_1: controllers.PersonController,
  // @LINE:12
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    PersonController_1: controllers.PersonController,
    // @LINE:12
    Assets_0: controllers.Assets
  ) = this(errorHandler, PersonController_1, Assets_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, PersonController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """person""", """controllers.PersonController.addPerson(req:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """show""", """controllers.PersonController.showPerson(id:java.lang.Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """delete""", """controllers.PersonController.deletePerson(id:java.lang.Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_PersonController_addPerson0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("person")))
  )
  private[this] lazy val controllers_PersonController_addPerson0_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      PersonController_1.addPerson(fakeValue[play.mvc.Http.Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "addPerson",
      Seq(classOf[play.mvc.Http.Request]),
      "POST",
      this.prefix + """person""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_PersonController_showPerson1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("show")))
  )
  private[this] lazy val controllers_PersonController_showPerson1_invoker = createInvoker(
    PersonController_1.showPerson(fakeValue[java.lang.Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "showPerson",
      Seq(classOf[java.lang.Long]),
      "GET",
      this.prefix + """show""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_PersonController_deletePerson2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("delete")))
  )
  private[this] lazy val controllers_PersonController_deletePerson2_invoker = createInvoker(
    PersonController_1.deletePerson(fakeValue[java.lang.Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "deletePerson",
      Seq(classOf[java.lang.Long]),
      "GET",
      this.prefix + """delete""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_Assets_at3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at3_invoker = createInvoker(
    Assets_0.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_PersonController_addPerson0_route(params@_) =>
      call { 
        controllers_PersonController_addPerson0_invoker.call(
          req => PersonController_1.addPerson(req))
      }
  
    // @LINE:8
    case controllers_PersonController_showPerson1_route(params@_) =>
      call(params.fromQuery[java.lang.Long]("id", None)) { (id) =>
        controllers_PersonController_showPerson1_invoker.call(PersonController_1.showPerson(id))
      }
  
    // @LINE:9
    case controllers_PersonController_deletePerson2_route(params@_) =>
      call(params.fromQuery[java.lang.Long]("id", None)) { (id) =>
        controllers_PersonController_deletePerson2_invoker.call(PersonController_1.deletePerson(id))
      }
  
    // @LINE:12
    case controllers_Assets_at3_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at3_invoker.call(Assets_0.at(path, file))
      }
  }
}
