<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>奖品记录</title>
<link href="${pageContext.request.contextPath}/css/prizes.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/style.min862f.css?v=4.1.0"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-table.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-table.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/js_lib/plugin/layui-v2.2.2/css/layui.css">
</head>
<body class="gray-bg">
	<div class="button-box" align="center"></div>
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>
							奖品记录
						</h5>
					</div>
					<div class="ibox-content">
						<div class="input-group">
							<table>
								<tr>
									<td class="txt" align="right">日期：</td>
									<td><input class="txtbody" type="text" id="datetimeStart"
										onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></td>
									<td class="txt" align="right">至：</td>
									<td><input class="txtbody" type="text" id="datetimeEnd"
										onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" /></td>
									<td class="txt"></td>
									<td>
										<div class="button-box2">
											<a id="aa" onclick="query()">查询</a>
										</div>
									</td>
								</tr>
							</table>

						</div>
						
						<div class="queryAuditRecord">
							<table id="bootstrap"></table>
						</div>
						
					</div>
				</div>
			</div>
		</div>

	</div>
	<script language="javascript" type="text/javascript"
		src="${pageContext.request.contextPath}/js_lib/jquery-1.9.1.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js_lib/bootstrap.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js_lib/bootstrap-table.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js_lib/bootstrap-table-zh-CN.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js_lib/bootstrap-table-export.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js_lib/pdfmake.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js_lib/vfs_fonts.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js_lib/xlsx.full.min.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js_lib/FileSaver.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js_lib/tableExport.js"></script>
	<script language="javascript" type="text/javascript"
		src="${pageContext.request.contextPath}/js_lib/plugin/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="${ctx}/js_lib/plugin/layui-v2.2.2/layui.js"></script>
	<script type="text/javascript">
	
		$(function() {
			layui.use('layer',function(){
				var layer = layui.layer;
			});
			initPrizesData();
		});
		
		function query(){
			var dateStart = $("#datetimeStart").val();
			var dateEnd = $("#datetimeEnd").val();
			if(dateStart == "" || dateEnd == ""){
				layer.msg("请输入日期进行查询！",{icon:5});
			}else if(dateStart > dateEnd){
				layer.msg("请按照日期的先后进行查询！",{icon:5});
			}else{
				$("#bootstrap").bootstrapTable("emptyTable");
				initPrizesData();
			}
		}
		
		function initPrizesData(){
			$("#bootstrap").bootstrapTable({
				url : "/prize/address", //请求后台的URL（*）
				method : 'post', //请求方式（*）
				striped : true, //是否显示行间隔色
				cache : true, //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
				pagination : true, //是否显示分页（*）
				sortable : true, //是否启用排序
				sortOrder : "asc", //排序方式
				sidePagination : "server", //分页方式：client客户端分页，server服务端分页（*）
				pageNumber : 1, //初始化加载第一页，默认第一页
				pageSize : 10, //每页的记录行数（*）
				pageList : [ 5, 10, 20, 50], //可供选择的每页的行数（*）
				search : false, //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
				strictSearch : false,
				showColumns : true, //是否显示所有的列
				showRefresh : false, //是否显示刷新按钮
				minimumCountColumns : 3, //最少允许的列数
				clickToSelect : false, //是否启用点击选中行
				height : 560, //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
				uniqueId : "ee_number", //每一行的唯一标识，一般为主键列
				showToggle : false, //是否显示详细视图和列表视图的切换按钮
				cardView : false, //是否显示详细视图
				detailView : false, //是否显示父子表
				queryParams : queryRecordParams,
				responseHandler : function(res) {
					return res;
				},
				onLoadSuccess : function(data) { //加载成功时执行  
				},
				onLoadError : function() { //加载失败时执行  
				},
				//showExport : true,//是否显示导出按钮,boolean
				exportDataType : "selected",//默认basic：只导出当前页的表格数据；all：导出所有数据；selected：导出选中的数据,String
				exportTypes : ['xlsx','doc','pdf'],//description: export types, support types: 'json', 'xml', 'png', 'csv', 'txt', 'sql', 'doc', 'excel', 'xlsx', 'pdf'类型Array
				exportOptions : {
					ignoreColumn: [0,0],//忽略第一列的索引
					ignoreColumn: [0,6],//忽略操作的索引
				},
				columns : [ 
				{
					field : "userid",
					title : '工号',
					align : "center",
				}, {
					field : 'username',
					title : '姓名',
					align : "center",
				}, {
					field : 'receivename',
					title : '收货人姓名',
					align : 'center'
				}, {
					field : 'receivephone',
					title : '收货人电话',
					align : 'center',
				},{
					field : 'address',
					title : '收货地址',
					align : 'center',
				},{
					field : "prizename",
					title : '奖品名称',
					align : 'center'
				},{
					field : "modifydate",
					title : '中奖时间',
					align : 'center',
					formatter : dateFormatter,
					sortable : true
				}]
			});
		}
		
		//发送的参数
		function queryRecordParams(params) {
			var dateStart = $("#datetimeStart").val();
			var dateEnd = $("#datetimeEnd").val();
			return {
				pageSize : params.limit,
				pageNum : params.offset / params.limit + 1,
				sortOrder: params.order,
				sortColumn : params.sort,
				dateStart : dateStart || null,
				dateEnd : dateEnd || null
			};
		}
		
		//日期格式化
		function dateFormatter(value,row,index){
			if(value != null && value != "undefined" && value != ""){
				return transferTime(value).format("yyyy-MM-dd hh:mm:ss");
			}else {
		        return "-";
		    }
		}
		
	</script>
	<script type="text/javascript">
		function transferTime(cTime) {
			//将string串的时间毫秒值进行解析
			var jsonDate = new Date(parseInt(cTime));
			//为Date对象添加一个新属性，主要是将解析到的时间数据转换为我们熟悉的“yyyy-MM-dd hh:mm:ss”样式
			Date.prototype.format = function(format) {
				var o = {
					//获得解析出来数据的相应信息，可参考js官方文档里面Date对象所具备的方法

					"y+" : this.getFullYear(),//得到对应的年信息
					"M+" : this.getMonth() + 1, //得到对应的月信息，得到的数字范围是0~11，所以要加一
					"d+" : this.getDate(), //得到对应的日信息
					"h+" : this.getHours(), //得到对应的小时信息 
					"m+" : this.getMinutes(), //得到对应的分钟信息
					"s+" : this.getSeconds(), //得到对应的秒信息
				}
				//将年转换为完整的年形式
				if (/(y+)/.test(format)) {
					format = format.replace(RegExp.$1,
							(this.getFullYear() + "")
									.substr(4 - RegExp.$1.length));
				}

				//连接得到的年月日 时分秒信息
				for ( var k in o) {
					if (new RegExp("(" + k + ")").test(format)) {
						format = format.replace(RegExp.$1,
								RegExp.$1.length == 1 ? o[k] : ("00" + o[k])
										.substr(("" + o[k]).length));
					}
				}
				return format;
			}
			var newDate = jsonDate;
			return newDate;
		}
	</script>
</body>

</html>