// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/AkhilaV/Documents/DemoBackend/conf/routes
// @DATE:Thu Jan 24 12:06:48 IST 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:5
  FoodController_3: controllers.FoodController,
  // @LINE:7
  HotelController_0: controllers.HotelController,
  // @LINE:11
  HomeController_2: controllers.HomeController,
  // @LINE:13
  CountController_1: controllers.CountController,
  // @LINE:15
  AsyncController_4: controllers.AsyncController,
  // @LINE:18
  Assets_5: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:5
    FoodController_3: controllers.FoodController,
    // @LINE:7
    HotelController_0: controllers.HotelController,
    // @LINE:11
    HomeController_2: controllers.HomeController,
    // @LINE:13
    CountController_1: controllers.CountController,
    // @LINE:15
    AsyncController_4: controllers.AsyncController,
    // @LINE:18
    Assets_5: controllers.Assets
  ) = this(errorHandler, FoodController_3, HotelController_0, HomeController_2, CountController_1, AsyncController_4, Assets_5, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, FoodController_3, HotelController_0, HomeController_2, CountController_1, AsyncController_4, Assets_5, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """foods""", """controllers.FoodController.getFood()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """hotels""", """controllers.HotelController.getHotel()"""),
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """count""", """controllers.CountController.count"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:5
  private[this] lazy val controllers_FoodController_getFood0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("foods")))
  )
  private[this] lazy val controllers_FoodController_getFood0_invoker = createInvoker(
    FoodController_3.getFood(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FoodController",
      "getFood",
      Nil,
      "GET",
      this.prefix + """foods""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_HotelController_getHotel1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("hotels")))
  )
  private[this] lazy val controllers_HotelController_getHotel1_invoker = createInvoker(
    HotelController_0.getHotel(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HotelController",
      "getHotel",
      Nil,
      "GET",
      this.prefix + """hotels""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_HomeController_index2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index2_invoker = createInvoker(
    HomeController_2.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_CountController_count3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("count")))
  )
  private[this] lazy val controllers_CountController_count3_invoker = createInvoker(
    CountController_1.count,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CountController",
      "count",
      Nil,
      "GET",
      this.prefix + """count""",
      """ An example controller showing how to use dependency injection""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_AsyncController_message4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_AsyncController_message4_invoker = createInvoker(
    AsyncController_4.message,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      this.prefix + """message""",
      """ An example controller showing how to write asynchronous code""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_Assets_versioned5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned5_invoker = createInvoker(
    Assets_5.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:5
    case controllers_FoodController_getFood0_route(params@_) =>
      call { 
        controllers_FoodController_getFood0_invoker.call(FoodController_3.getFood())
      }
  
    // @LINE:7
    case controllers_HotelController_getHotel1_route(params@_) =>
      call { 
        controllers_HotelController_getHotel1_invoker.call(HotelController_0.getHotel())
      }
  
    // @LINE:11
    case controllers_HomeController_index2_route(params@_) =>
      call { 
        controllers_HomeController_index2_invoker.call(HomeController_2.index)
      }
  
    // @LINE:13
    case controllers_CountController_count3_route(params@_) =>
      call { 
        controllers_CountController_count3_invoker.call(CountController_1.count)
      }
  
    // @LINE:15
    case controllers_AsyncController_message4_route(params@_) =>
      call { 
        controllers_AsyncController_message4_invoker.call(AsyncController_4.message)
      }
  
    // @LINE:18
    case controllers_Assets_versioned5_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned5_invoker.call(Assets_5.versioned(path, file))
      }
  }
}
