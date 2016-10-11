<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<html>
<head>
    <title>Customer Info Search</title>

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/main.css">


    <script type="text/javascript"  src="scripts/jquery-3.1.1.js"></script>
    <script type="text/javascript"  src="scripts/bootstrap.min.js"></script>
    <script type="text/javascript" src="scripts/pub.js"></script>



</head>
<body>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-8">
            <h2 class="page-header">客户资料查询</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-1"><lable>客户名称</lable></div>
        <div class="col-md-2"><input id="custName" class="form-control"></div>
        <div class="col-md-1"></div>
        <div class="col-md-1"><lable>客户代码</lable></div>
        <div class="col-md-2"><input id="custCode" class="form-control"></div>
        <div class="col-md-1"><button type="button" class="btn btn-default" id="btn_search">查询</button></div>
        <div class="col-md-1"> <button type="button" class="btn btn-default"  id="btn_reset">重置</button></div>
    </div>
    <tr> &nbsp;</tr>
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-2">
            <button type="button" class="btn btn-default"  id="btn_checkEmail">检查邮箱地址</button>
        </div>
    </div>
    <tr> &nbsp;</tr>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <table class="table table-striped table-bordered">
                <tr >
                    <th>客户名称</th>
                    <th>客户代码</th>
                    <th>所在省市</th>
                    <th>联系人</th>
                    <th>电话</th>
                    <th>邮箱</th>
                    <th>状态</th>
                </tr>
                <tbody id="contents"></tbody>
            </table>
        </div>
        <div class="col-md-1"></div>
    </div>
    <div class="row">
        <div class="col-md-1"></div>
        <div id="id_tipsForTable" hidden="true" class = "col-md-10 alert alert-info">
            <div class = "col-md-3 pager">
                显示 <lable id="id_showListNum" class="badge">0</lable> 条 ，共 <lable id="id_allListNum" class="badge">0</lable> 条
            </div>
            <div class="col-md-3 pager">
                有效的 <label id="id_validNum" class="badge">0</label> 条，无效的 <lable id="id_invalidNum" class="badge">0</lable> 条
            </div>
            <div class="col-md-4 pager">
                        <li><a href="#">Previous</a></li>
                        <li id="id_pageNum" class = "badge">1</li>
                        <li><a href="#">Next</a></li>
            </div>
        </div>
        <div class="col-md-1"></div>
    </div>


    <div id="footer" class="container">
        <nav class="navbar navbar-default navbar-fixed-bottom">
            <div class="navbar-inner navbar-content-center">
                <p class="text-muted credit" style="padding: 10px;">
                    Copyright @ 2015-2016. Transportation Management System. All Right reserved
                </p>
            </div>
        </nav>
    </div>
</body>
</html>