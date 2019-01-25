// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/AkhilaV/Documents/DemoBackend/conf/routes
// @DATE:Thu Jan 24 12:06:48 IST 2019


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
