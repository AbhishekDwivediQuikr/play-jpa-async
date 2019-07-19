
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>

<html>
    <head>
        <title>"""),_display_(/*7.17*/title),format.raw/*7.22*/("""</title>
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*8.59*/routes/*8.65*/.Assets.at("images/favicon.png")),format.raw/*8.97*/("""">
        <script src=""""),_display_(/*9.23*/routes/*9.29*/.Assets.at("javascripts/jquery-2.2.0.min.js")),format.raw/*9.74*/("""" type="text/javascript"></script>
    </head>
    <body>
        """),_display_(/*12.10*/content),format.raw/*12.17*/("""
    """),format.raw/*13.5*/("""</body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2019-07-19T17:04:36.504
                  SOURCE: /Users/abhishekkumardwivedi/Documents/play-samples-play-java-jpa-example/app/views/main.scala.html
                  HASH: 2619d17b8f5355a3a8808326add1e0668efb8408
                  MATRIX: 952->1|1076->32|1103->33|1180->84|1205->89|1298->156|1312->162|1364->194|1415->219|1429->225|1494->270|1588->337|1616->344|1648->349
                  LINES: 28->1|33->2|34->3|38->7|38->7|39->8|39->8|39->8|40->9|40->9|40->9|43->12|43->12|44->13
                  -- GENERATED --
              */
          