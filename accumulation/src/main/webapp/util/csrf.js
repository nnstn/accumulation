AJAXPacket=function(url,text){
        var temp=document.cookie.split("; ");
        var DemixRandomNumParam;  
        var cookieKey;
        for (var len=0;len<temp.length;len++){  
          cookieKey=temp[len].split("=")[0]; 
          if (cookieKey.indexOf("__SI_TOKEN_")!=-1||cookieKey=="__SI_TOKEN_"){
           DemixRandomNumParam = temp[len].split("=")[1];
          }
        }
	this.url=url;
	this.data=new JMap();
	//try ..catch部分为处理订单提交报文中的公用节点而用，在主页面中取custID,idNO,opCode传入订单提交页面
	try{
		this.data.add("crmActiveCustId",$("#crmActiveCustId").val());
		this.data.add("crmActiveIdNo",$("#crmActiveIdNo").val());
		this.data.add("crmActiveOpCode",$("input[name='opCode']").val());
		this.data.add("crmActiveSessionId",$("input[name='crmActiveSessionId']").val());
        this.data.add("DemixRandomNumParam",DemixRandomNumParam);
	}catch(e){
		
	}
  this.statusText=text;
	this.guid="";
};
