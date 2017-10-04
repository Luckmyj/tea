<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>茶叶管理系统</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">茶叶品级管理系统</a>
            <ul class="nav navbar-nav">
                <li><a href="index.jsp">添加</a></li>
                <li><a href="statistics.jsp">统计</a></li>
                <li class="active"><a href="vote.jsp">投票</a></li>
                <li><a href="score.html">作业要求</a></li>
            </ul>
        </div>
    </nav>

    <div class="container">
        <div class="row">
            <div class="col-md-7">

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">群众最喜欢的茶叶  <span style="float: right;"><a onclick="loadUserModal(1,null)">查看历史投票</a></span></h3>
                    </div>
                    <div class="panel-body">
						<div class="row" id="teaMessage">
						</div>
					</div>
                </div>
            </div>
            <div class="col-md-5">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title" id="updateTime"></h3>
                    </div>
                    <div class="panel-body">

                        <!-- 图表要绘制到这里，设定宽度和高度 -->
                        <div id="chart1" style="height:370px;">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel">
            <div class="modal-dialog" role="document">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                  <h4 class="modal-title" id="loginModalLabel">登录</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                      <input type="text" class="form-control" placeholder="请输入手机号" id="phoneNum">
                    </div>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                  <button type="button" class="btn btn-primary" onclick="verifyPhone()">登录</button>
                </div>
              </div>
            </div>
          </div>

    <!-- 弹出框 -->
    <div class="modal fade" id="userModal" tabindex="-1" role="dialog" aria-labelledby="teaInfoModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="teaInfoModalLabel">历史投票记录</h4>
                </div>
                <div class="modal-body">
                
                	<table class="table table-bordered table-hover">
                		
                		<tr>
                			<th>序号</th>
                			<th>手机号</th>
                			<th>时间
                				
                				 <button type="button" class="btn btn-link btn-default btn-xs" onclick= "loadUserModal('1','asc')">
                                        <span class="glyphicon glyphicon-triangle-top" aria-hidden="true"></span>
                                </button>
                                <button type="button" class="btn btn-link btn-default btn-xs" onclick= "loadUserModal('1','desc')">
                                        <span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true"></span>
                                </button>
                			</th>
                		</tr>
                	</table>
                	
                	

	                </div>
                <div class="modal-footer">
                					<!-- 分页 -->
                        <nav aria-label="Page navigation pagination-sm" style="float: left;">
                            <ul class="pagination" style="margin:0%" id="pageList" >
                                
                            </ul>
                        </nav>
                
                    <button type="button" class="btn btn-default" data-dismiss="modal">确定</button>
                </div>
            </div>
        </div>
    </div>


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>

    <!-- 图表 js 库 -->
    <script src="js/echarts.min.js"></script>

    <script type="text/javascript">
        // 设置图表为全局变量
        var chart1 = null;
        
        //var uri = "http://47.94.18.152:8080/homework/";
        var uri = "http://localhost:8526/101/";
        
        $(document).ready(function () {
        	
        	loadTeaMessage();
        	
            // 基于准备好的 dom，初始化echarts实例，并设置全局变量 chart1
            chart1 = echarts.init(document.getElementById('chart1'));

            // 加载完毕页面就加载排行榜
            loadRank();

            // 然后每两秒更新一次排行榜，自己修改为 30 s
            setInterval('loadRank()', 30000);
        })


        // 获取排行榜
        function loadRank() {
        	
        	var votes = new Array;
        	var votesView = new Array;
        	var names = new Array;
        	var namesView = new Array;
        	
        	var time = new Date();
        	time = time.toLocaleString();
        	$("#updateTime").html("排行榜实时更新时间：" + time);
      	   $.ajax({
               type : 'POST',
               url : uri + 'tea/listDesc',
               async : true,
               contentType : 'application/json;charset=utf-8',
               data : JSON.stringify({
            	   "phone":phoneNum
               }),
               success : function(data) {
              	 
            	   //alert(JSON.stringify(data));
            	   
            	   $.each(data,function(index,obj){
            		   
            		   votes.push(obj.vote);
            		   names.push(obj.name);
            	   })
            	   
            	   for(var i = 0; i < votes.length ; i++){
            		   
            		   votesView[i] = votes[votes.length -1 - i];
            		   namesView[i] = names[votes.leggth -1 - i];
            	   }
                   // 指定图表的配置项和数据
                   var addedInfo = new Array();
                   for(var i = 0; i< names.length; i++){
                	   
                	   addedInfo[i] = names[names.length - i - 1] + "</br>得票数:" + votes[names.length - i - 1];
                   }
                    
                   
                   var option = {
                       title: {
                           text: '得票数'
                       },
                       tooltip: {// 鼠标放上展示的提示信息格式
                           trigger: 'item',
                           formatter: function(param) {
                        	      // alert(JSON.stringify(param));
                        	      return addedInfo[param.dataIndex];
                         },
                       },
                       xAxis: {
                           type: 'value',
                       },
                       yAxis: {
                           type: 'category',
                           data: ["第8名", "第7名", "第6名", "第5名", "第4名", "第3名", "第2名", "第1名"]
                       },
                       series: [{
                           type: 'bar',//==============使用得票数填充 data
                           data: votesView,
                           itemStyle: {
                               normal: {
                                   color: function (param) {
                                       var colorList = [
                                           '#C1232B', '#B5C334', '#FCCE10', '#E87C25', '#27727B',
                                           '#FE8463', '#9BCA63'
                                       ];
                                       return colorList[param.dataIndex]
                                   }
                               }
                           }
                       }]
                   };

                   // 使用指定的配置项和数据显示图表。
                   chart1.setOption(option);
               },
               error : function(msg) {
              	
                    alert(JSON.stringify(msg));
               }
           });
        }
        
        
        function loadTeaMessage() {
        	
            $.ajax({
                 type : 'POST',
                 url : uri + 'tea/vote',
                 async : true,
                 contentType : 'application/json;charset=utf-8',
                 data : JSON.stringify({
                	 
                 }),
                 success : function(data) {
                	 
                	 $("#teaMessage").html("");
                	 $.each(data,function(index,obj){
                		 
                		 $("#teaMessage").append("<div class='col-md-3'><div style='background-color: burlywood; padding: 10px; margin-top: 5px'> <img src='img"+ obj.image + 
                		 "' class='img-thumbnail'> <button class='btn btn-default' type='button' onclick='loadVote("+ obj.id +
                				 ")' style='width: 100%; margin-top: 10px;'>投票("+ obj.vote +
                				 ")</button></div></div>");
                	 })
                 },
                 error : function(msg) {
                	
                      alert(JSON.stringify(msg));
                 }
               });
                
            };
        
            function loadVote(id){
            	
            	   $.ajax({
                       type : 'POST',
                       url : uri + 'tea/update',
                       async : true,
                       contentType : 'application/json;charset=utf-8',
                       data : JSON.stringify({
                    	   "id":id
                       }),
                       success : function(data) {
                      	 
                    	   if(data.errorCode == 0){
                    		   loadTeaMessage();
                    	   }else if(data.errorCode == -1000){
                    		// 投票
                               $('#loginModal').modal();
                    	   }else{
                    		   alert(JSON.stringify(data.errorMessage));
                    	   }
                    	   
                       },
                       error : function(msg) {
                      	
                            alert(JSON.stringify(msg));
                       }
                   });
            }
            
            function verifyPhone(){
            	
            	var reg = /^1[3|4|5|7|8][0-9]{9}$/; //验证规则

            	var phoneNum = $("#phoneNum").val();//手机号码

            	var flag = reg.test(phoneNum); //true
            	
            	if(flag){
            		
            		 $('#loginModal').modal('hide');
            		 loadUser(phoneNum);
            		 
            	}else{
            		alert("请输入正确的手机号");
            	}
            }
            
            function loadUser(phoneNum){
            	
         	   $.ajax({
                   type : 'POST',
                   url : uri + 'user/save',
                   async : true,
                   contentType : 'application/json;charset=utf-8',
                   data : JSON.stringify({
                	   "phone":phoneNum
                   }),
                   success : function(data) {
                  	 
                	   //alert(JSON.stringify(data));
                   },
                   error : function(msg) {
                  	
                        alert(JSON.stringify(msg));
                   }
               });
            }
            
            
            function loadUserModal(pageIndex,sort){
        	   $.ajax({
                   
                   type:'POST',
                  
                   url:uri + 'user/list',
                  
                   async:true,
                  
                   // 说明提交给服务器的数据是json 格式
                   contentType : 'application/json;charset=utf-8',
                  
                   data:JSON.stringify({

                	   "pageIndex" : pageIndex,
                	   "sort" : sort
                   }),
                  
                   dataType:'json',
                  
                   success:function(data){
                	   //alert(JSON.stringify(data));
                	   $(".table tr:not(:first)").html("");
                	   $.each(data.data,function(index,obj){
                		   
                		   var current = new Date(obj.current);
                		   current = current.toLocaleString();
                		   var phone = obj.phone.substring(0,3) + "*****" + obj.phone.substring(8);
                		   
                		   
                           $(".table").append("<tr><td>"+ (index + 1) +
                                     "</td><td>"+ phone +
                                     "</td><td>"+ current +
                                     "</td></tr>");
                          
                      });
                	   // 单独加的时候会判断为字符串的拼接
                	   var pageUp = (pageIndex - 1 + 2);
                	   
                	   // 上一页
                	   $("#pageList").html("");
                	   $("#pageList").append("<li ><a  " + ( pageIndex == 1 ? "class='btn disabled'" : '') + " onclick= \"loadUserModal('"+ (pageIndex - 1) +"','" + sort + "')\" aria-label='Previous'><span aria-hidden='true'>&laquo;</span> </a></li>");
                	   
                	   for(var i = 1; i <= data.allPageCount; i++){
                		   
                		   $("#pageList").append("<li  " + ( pageIndex == i ? "class='active'" : '') + "><a onclick= \"loadUserModal('"+ i +"','" + sort + "')\">"+ i +"</a></li>");
                	   }
                	   
                	   // 下一页
                	   $("#pageList").append("<li ><a  " + ( pageIndex == data.allPageCount ? "class='btn disabled'" : '') + " onclick= \"loadUserModal('"+ pageUp +"','" + sort + "')\" aria-label='Next'><span aria-hidden='true'>&raquo;</span></a></li>");

                	   
                	   $("#userModal").modal();
                   },
                  
                   error:function(msg){
                       alert(JSON.stringify(msg));
                   }
               });
            }
    </script>
</body>

</html>