/**
 * ztree的参数配置
 */
var setting = {
	check : {
		//复选框
		enable : true,
		//勾选框类型
		chkStyle : "checkbox",
	},
	view: {  
		enable : true,
		showLine : true,
		//鼠标移到节点上，显示自定义控件
		//addHoverDom:addHoverDom,
		//removeHoverDom:removeHoverDom,
		},          
	edit : {
		//设置ztree是否处于编辑状态
		enable : true,
		//是否显示删除按钮
		showRemoveBtn : true,
		//是否显示编辑按钮
		showRenameBtn : true,
		//鼠标移到按钮上显示的提示信息
		removeTitle: "删除节点",
		renameTitle: "更新节点",
	},
	data : {
		simpleData : {
			enable : true,
			idKey : "id",
			pIdKey : "parentId",
			rootPID : 0
		}
	},
	callback : {
		//节点点击
		onClick : zTreeOnClick,
		//checkbox点击
		onCheck : zTreeOnCheck,
		//增加父节点
		addLeaf : addLeaf,
		//增加子节点
		addParent : addParent,
		//移除事件
		beforeRemove : beforeRemove,
		//修改事件
		onRename : onRename,
	},
}

var ztree;
var treeNode;
var newCount = 1;
function zTreeOnClick(event, treeId, treeNode) {
};
function zTreeOnCheck(event, treeId, treeNode) {
	$.cookie("id", treeNode.id);
	$.cookie("level",treeNode.level);
};

/**
 * 添加父节点
 */
function addParent() {
	var name = $("#name").val();
	var url = $("#url").val();
	var icon = $("#icon").val();
	window.location.href = "/timeSheet/menu/addParentNode?name=" + name
			+ "&url=" + url + "&icon=" + icon;
}
/**
 * 添加子节点
 */
function addLeaf() {
	var name = $("#name").val();
	var url = $("#url").val();
	var icon = $("#icon").val();
	var parentId = $.cookie("id");
	var level = $.cookie("level");
	if(parentId != null && level != null){
		window.location.href = "/timeSheet/menu/addNodeByParent?name=" + name
		+ "&url=" + url + "&icon=" + icon + "&parentId=" + parentId+"&level="+level;
	}else{
		alert("请先选择一个节点");
	}
}
/**
 * 删除节点
 */
function beforeRemove(treeId,treeNode){
	var nodeId = treeNode.id;
	var level = treeNode.level;
	if(level == 0){//一级菜单
		var oneLevel = confirm("你确定要删除该节点以及该节点下的所有节点吗?");
		if(oneLevel){
			$.post('/timeSheet/menu/delNode?nodeId='+nodeId,function(data){
			});
		}else{
			return false;
		}
	}else{//二级菜单
		var twoLevel = confirm("你确定要删除该节点吗?");
		if(twoLevel){
			$.post('/timeSheet/menu/delNode?nodeId='+nodeId,function(data){
			});
		}else{
			return false;
		}
	}
}
/**
 * 更新节点
 */
function onRename(event,treeId,treeNode){
	var nodeId = treeNode.id;
	var nodeName = treeNode.name;
	$.post("/timeSheet/menu/updateNode?nodeId="+nodeId+"&name="+nodeName,function(){
		//取消节点的选中状态
		ztree = $.fn.zTree.getZTreeObj("menu");
		ztree.cancelSelectedNode();
		alert("更新节点名称成功!");
	});
}

$(function() {
	$.ajax({
		url : webContex + 'menu/all',
		dataType : "json",
		type : "post",
		success : function(data) {
			treeNode = data;
			$.fn.zTree.init($("#menu"), setting, data).expandAll(true);
			$("#addLeaf").bind("click", addLeaf);
			$("#addParent").bind("click", addParent);
		}
	});
});