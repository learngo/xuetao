 var w=window.innerWidth
 || document.documentElement.clientWidth
 || document.body.clientWidth;
 var h=window.innerHeight
 || document.documentElement.clientHeight
 || document.body.clientHeight;
var Init= {
     webUrl:"/",
     windowWidth:w,
     windowHeight:h
  };
//$(document).bind("contextmenu",function(e){
//	    return false;
//	});

//$.ajax({
//url : Init.webUrl+'/member/order/modifyCartService.json',
//type : "Get",
//data : params,
////contentType : "application/json;charset=utf-8",
////contentType : "application/x-www-form-urlencoded;charset=utf-8",
// contentType: "application/x-www-form-urlencoded; charset=utf-8",
//dataType : "json",
//success : function(resultData) {
//}
//});
/**
$.ajax({
url : Init.webUrl+'/member/order/modifyCartGood.json',// action 
   @RequestMapping(value="/modifyCartGood")
	@ResponseBody
	public JsonObject modifyCartGood
	{};
type : "POST",
data : params,
contentType : "application/x-www-form-urlencoded;charset=utf-8",
dataType : "json",
success : function(resultData) {
	alert(resultData.data.cartGoods[0].statu);
}
});
**/