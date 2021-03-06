<%--
  Created by IntelliJ IDEA.
  User: dongmengyuan
  Date: 17-11-19
  Time: 下午2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <script src="./view/system_manager/jquery/jq.js"></script>
    <script src="./view/system_manager/jquery/bootstrap.min.js"></script>
    <script src="./view/system_manager/javascript/employee.js"></script>
    <link rel="stylesheet" href="./view/system_manager/Bootstrap/bs.css">
    <link rel="stylesheet" href="./view/system_manager/css/manage.css">
    <link rel="stylesheet" href="./view/system_manager/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="display.css">

    <title>employee</title>
</head>
<body>

<a href="./index.jsp" style="float: right">&nbsp;<span class="fa fa-sign-out" aria-hidden="true"> </span> 退出</a>
<a href="#" style="float: right"><span class="fa fa-user" aria-hidden="true"> </span> 系统管理员</a>

<p style="font-size: 40px;text-align: center;margin: 20px;font-family: 'AR PL UKai TW MBE'">FZN影院管理系统</p>

<nav class="navbar navbar-inverse" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header" id="too">
            <ul class="nav navbar-nav navbar-left">
                <li><a href="./employee.jsp">员工管理</a></li>
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
    <table class="table table-hover" id="ss" onclick="find(this)">
        <thead>
        <tr>
            <th style='text-align: center;width: 12%;'>编号</th>
            <th style='text-align: center;width: 12%;'>姓名</th>
            <th style='text-align: center;width: 12%;'>性别</th>
            <th style="text-align: center;width: 12%;">年龄</th>
            <th style="text-align: center;width: 15%;">职位</th>
            <th style='text-align: center;width: 17%;'>电话</th>
            <th style="text-align: center;width: 21%;">邮箱</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>000001</td>
            <td>张一</td>
            <td>女</td>
            <td>20</td>
            <td>系统管理员</td>
            <td>12344336234</td>
            <td>123456@qq.com</td>
        </tr>
        <tr>
            <td>000002</td>
            <td>张二</td>
            <td>女</td>
            <td>21</td>
            <td>经理</td>
            <td>12344336234</td>
            <td>123455@qq.com</td>
        </tr>
        <tr>
            <td>000003</td>
            <td>张三</td>
            <td>女</td>
            <td>22</td>
            <td>售票员</td>
            <td>12344336234</td>
            <td>122456@qq.com</td>
        </tr>
        <tr>
            <td>000004</td>
            <td>张四</td>
            <td>女</td>
            <td>23</td>
            <td>售票员</td>
            <td>12344336234</td>
            <td>223456@qq.com</td>
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
                    <h4>添加员工</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">编号:</label>
                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="number"
                                              required="required" onblur="checkNum('number')"></label>
                                <span id="1" style="color:red;"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">名字:</label>
                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="name"
                                              required="required" onblur="checkName('name')"></label>
                                <span id="2" style="color:red;"></span>
                            </div>

                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">性别:</label>
                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="s"
                                              required="required" onblur="checkSex('s')"></label>
                                <span id="3" style="color:red;"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">年龄:</label>
                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="age"
                                              required="required" onblur="checkAge('age')"></label>
                                <span id="4" style="color:red;"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">电话:</label>

                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="tel"
                                              required="required" onblur="checkTel('tel')"></label>
                                <span id="5" style="color:red;"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">邮箱:</label>
                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="emil"
                                              required="required" onblur="checkEmil('emil')"></label>
                                <span id="6" style="color:red;"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">职位:</label>
                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="job"
                                              required="required" onblur="checkJob('job')"></label>
                                <span id="7" style="color:red;"></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <span id="8" style="color:red;"></span>
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="submit" id="add" class="btn btn-primary" onclick="add(this)">添加</button>
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
                            <label class="col-sm-3 control-label">编号:</label>
                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="num"></label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">名字:</label>
                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="nam"></label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">性别:</label>
                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="sex"></label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">年龄:</label>
                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="ag"></label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">电话:</label>

                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="tele"></label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">邮箱:</label>
                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="email"></label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">职位:</label>
                            <div class="col-sm-8">
                                <label><input type="text" class="form-control" id="work"></label>
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
