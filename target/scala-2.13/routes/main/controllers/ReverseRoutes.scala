// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/abhishekkumardwivedi/Documents/play-samples-play-java-jpa-example/conf/routes
// @DATE:Fri Jul 19 17:04:35 IST 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:7
package controllers {

  // @LINE:7
  class ReversePersonController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def deletePerson(id:java.lang.Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "delete" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[java.lang.Long]].unbind("id", id)))))
    }
  
    // @LINE:7
    def addPerson(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "person")
    }
  
    // @LINE:8
    def showPerson(id:java.lang.Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "show" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[java.lang.Long]].unbind("id", id)))))
    }
  
  }

  // @LINE:12
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def at(file:String): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }


}
