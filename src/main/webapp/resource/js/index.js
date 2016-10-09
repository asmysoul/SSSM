$(window).load(function(){
    $("#loading").fadeOut();
});

$('#menu').tree({
    url: realpath+ '/menu',
    lines : true,
    onClick:function(node){
    	if(node.attributes){
    	openTab(node);
    	}
	}
});

function openTab(node){
	if($("#tt").tabs("exists",node.text)){
		$("#tt").tabs("select",node.text);
	}else{
		var content="<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src=" + realpath + "/" + node.attributes+"></iframe>";
		$("#tt").tabs("add",{
			title:node.text,
			iconCls:node.iconCls,
			closable:true,
			content:content
		});
	}
}