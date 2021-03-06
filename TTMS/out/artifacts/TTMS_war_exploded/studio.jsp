<%--
  Created by IntelliJ IDEA.
  User: dongmengyuan
  Date: 17-11-19
  Time: 下午2:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <script src="./view/system_manager/jquery/jq.js"></script>
    <script src="./view/system_manager/jquery/bootstrap.min.js"></script>
    <script src="./view/system_manager/javascript/stdio.js"></script>
    <link rel="stylesheet" href="./view/system_manager/Bootstrap/bs.css">
    <link rel="stylesheet" href="./view/system_manager/css/manage.css">
    <link rel="stylesheet" href="./view/system_manager/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="display.css">

    <title>stdio</title>
</head>
<body>
<a href="./index.jsp" style="float: right">&nbsp;<span class="fa fa-sign-out" aria-hidden="true"> </span> 退出</a>
<a href="#" style="float: right"><span class="fa fa-user" aria-hidden="true"> </span> 系统管理员 </a>


<p style="font-size: 40px;text-align: center;margin: 20px;font-family: 'AR PL UKai TW MBE'">FZN影院管理系统</p>

<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <ul class="nav navbar-nav navbar-left">
                <div class="navbar-header" id="too">
                    <ul class="nav navbar-nav navbar-left">
                        <li><a href="./employee.jsp">员工管理</a></li>
                    </ul>
                </div>
            </ul>
        </div>
        <div>
            <ul class="nav navbar-nav">
                <li><a href="./studio.jsp">演出厅管理</a></li>
                <li><a href="./seat.jsp">座位管理</a></li>
            </ul>
        </div>
    </div>
</nav>
<div id="center">
    <input type="text" placeholder="search" style="border-radius: 5px;height: 30px;">
    <!--<img src="./image/搜索.jpg" width="30px" height="30px">-->
    <button class="fa fa-search" style="width: 25px;height:25px;"></button>
</div>

<div id="ww">
    <table class="table table-hover" id="stdio" onclick="find(this)">
        <thead>
        <tr>
            <th style='text-align: center;width:15%;'>名称</th>
            <th style='text-align: center;width:17%;'>类型</th>
            <th style='text-align: center;width:15%;'>行</th>
            <th style='text-align: center;width:15%;'>列</th>
            <th style="text-align: center;width:20%;">状态</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>一号演出厅</td>
            <td>豪华</td>
            <td>1</td>
            <td>2</td>
            <td>可用</td>
        </tr>
        <tr>
            <td>二号演出厅</td>
            <td>大</td>
            <td>12</td>
            <td>12</td>
            <td>可用</td>
        </tr>
        <tr>
            <td>三号演出厅</td>
            <td>中</td>
            <td>10</td>
            <td>10</td>
            <td>可用</td>
        </tr>
        <tr>
            <td>四号演出厅</td>
            <td>小</td>
            <td>8</td>
            <td>8</td>
            <td>不可用</td>
        </tr>
        </tbody>
    </table>
    <button class="btn btn-danger" onclick="del(this)" style="float: right;margin: 5px;">删除</button>
    <button class="btn btn-primary" data-toggle="modal" data-target="#myModal" style="float: right;margin: 5px;">添加
    </button>
    <button class="btn btn-default" data-toggle="modal" data-target="#myModal1" onclick="model(this)"
            style="float: right;margin: 5px;">编辑
    </button>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" style="width:30%;padding:10px;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4>添加演出厅</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">名称:</label>
                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="name"
                                              onblur="checkName('name')"></label>
                                <span id="1" style="color:red;"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">类型:</label>
                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="type"
                                              onblur="checkType('type')"></label>
                                <span id="2" style="color:red;"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">行数:</label>
                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="row"
                                              onblur="checkRow('row')"></label>
                                <span id="3" style="color:red;"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">列数:</label>
                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="col" onblur="checkCol('col')">
                                </label>
                                <span id="4" style="color:red;"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">状态:</label>
                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="status"
                                              onblur="checkStatus('status')">
                                </label>
                                <span id="5" style="color:red;"></span>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" id="add"
                            onclick="add(this)">添加
                    </button>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" style="width:30%;padding:10px;">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4>编辑</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">名称:</label>
                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="nam"></label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">类型:</label>
                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="typ"></label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">行数:</label>
                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="rows"></label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">列数:</label>
                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="cols"></label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">状态:</label>
                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="statu"></label>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal" aria-hidden="true"
                            onclick="save(this)">保存
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
