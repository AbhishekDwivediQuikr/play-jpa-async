// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/abhishekkumardwivedi/Documents/play-samples-play-java-jpa-example/conf/routes
// @DATE:Fri Jul 19 15:23:17 IST 2019


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
