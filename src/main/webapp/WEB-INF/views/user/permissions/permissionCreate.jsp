<!--
=================================================================
* 시 스 템 명 : 사용자 생성 웹 UI
* 업 무 명 : 사용자 생성
* 프로그램명 permissions/permissionCreate.jsp(참여자 목록 리스트)
* 프로그램 개요 : 참여자 목록 리스트 화면
* 작 성 자 : 이인정
* 작 성 일 : 2018.07.10
* 화면 ID: UI-FDSC-8000
* 화면설계 ID: UI-SBSC-8200
=================================================================
수정자 / 수정일 :
수정사유 / 내역 :
=================================================================
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/xml" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div id="container">
<!-- location :s -->
<div class="location">
    <ul>
        <li><a href="/user/repository/" class="home">홈으로</a></li>
        <li><a href="/user/permissionList/" title="사용자 목록"> 사용자관리/사용자 목록</a></li>
        <!--마지막 경로-->
        <li><a href="/user/create/" title="사용자 생성">사용자 생성</a></li><!--마지막 경로-->
    </ul>
<%--    <div class="fr"  style="padding-top:15px;">
        <a href="/user/create/">
            <button type="button" class="button btn_default" title="사용자 생성">사용자 생성</button>
        </a>
    </div>--%>
</div>
<!--//location :e -->
<!-- contents :s -->
<div class="contents">
    <!-- Form 테이블 :s -->
    <%--<table summary="사용자초대 검색 테이블입니다." class="tbl_form02">--%>
        <%--<caption>--%>
            <%--사용자초대 검색--%>
        <%--</caption>--%>
        <%--<colgroup>--%>
            <%--<col style="width: *"/>--%>
        <%--</colgroup>--%>
        <%--<tbody>--%>
        <%--<tr>--%>
            <%--<th class="f_title">소스컨트롤러 사용자 검색</th>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<input type="text" id="searchInstRepoUserId" name="searchInstRepoUserId" placeholder="사용자 검색"--%>
                       <%--style="width:40%;"></td>--%>
        <%--</tr>--%>
        <%--<tr>--%>
            <%--<td>--%>
                <%--<li style="width:40%;">--%>
                    <%--<a href="#" class="wintoggle" style="width:40%;"><span class="RP_name">사용자 검색 목록 (<span--%>
                            <%--name="SrchPermissionUser" id="SrchPermissionUser">0</span>)<b class="nav_arrow"></b></span></a>--%>
                    <%--<ul class="togglemenu" style="width:320px; top:120px;padding-top:0px;" id="SrchPermissionUserList"--%>
                        <%--name="SrchPermissionUserList"></ul>--%>
                <%--</li>--%>
            <%--</td>--%>
        <%--</tr>--%>
        <%--</tbody>--%>
    </table>
        <table summary="사용자 생성 입력 테이블입니다." class="tbl_form02">
            <caption>
                참여자추가
            </caption>
            <colgroup>
                <col style="width: 18%"/>
                <col style="width: *"/>
            </colgroup>
            <tbody>
            <tr>
                <th colspan="2" class="f_title">사용자 생성</th>
            </tr>
            <tr>
                <th>아이디 (<span class="essential">*필수</span>)</th>
                <td>
                    <input type="text" id="permissionName" name="permissionName" value="" placeholder="영문소문자, 숫자, 2자리이상" pattern="^[a-zA-Z0-9-]*$">
                    <p class="desc" id="nameNotConfirmedAlert" style="color:#fb5666; ;">* 영문소문자, 숫자 2~12자로 입력해주시기 바랍니다.</p>
                </td>
            </tr>
            <tr>
                <th>이름<%-- (<span class="essential">*필수</span>)--%></th>
                <td>
                    <input type="text" id="PermissionDisplayName" name="PermissionDisplayName" value="" placeholder="이름은 2자 이상으로 입력해 주시기 바랍니다">
                    <%--<p class="desc">* 이름은 2자 이상으로 입력해 주시기 바랍니다.</p>--%>
                </td>
            </tr>
            <tr>
            <tr>
                <th>이메일</th>
                <td>
                    <input type="text"  name="permissionMail" id="permissionMail"  value="" placeholder="kpaas@nia.or.kr"
                    required="required"
                    pattern="^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$">
                    <p class="desc" style="color:#fb5666;" id="emailNotConfirmedAlert">* 이메일 주소 형식이 올바르지 않습니다.</p>
                </td>
            </tr>
            <tr>
                <th>비밀번호 (<span class="essential">*필수</span>)</th>
                <td>
                    <input type="password" name="password" value="" placeholder="6자리 ~ 16자리" id="newPasswordInput">
                    <p class="desc" style="color:#fb5666;">* 비밀번호는 6~16자로 입력해 주시기 바랍니다.</p>
                </td>
            </tr>
            <tr>
                <th>비밀번호 확인 (<span class="essential">*필수</span>)</th>
                <td>
                    <input type="password" name="password" value="" placeholder="비밀번호 다시 입력"  id="confirmPasswordInput">
                    <p class="desc" id="passwordNotConfirmedAlert" style="color:#fb5666; ;">* 비밀번호가 일치하지 않습니다.</p>
                </td>
            </tr>
            </tbody>
        </table>
    <div class="fr">
        <jsp:include page="../common/buttonCreateOnclick.jsp"></jsp:include>
        <%--<button type="button" class="button btn_default" title="생성" onclick='createUserBeforeValid();'>생성</button>--%>
        <button type="button" class="button btn_cancel" title="취소" onclick="procMovePage(-1)">취소</button>
    </div>
</div>
    <form name ="permissionList" id ="permissionList"  action = "/user/permissionList/" method="get"></form>
<!--//contents :e -->
</div>
<!--//contaniner :e -->
<!-- Top 가기 :s -->
<div class="follow" title="Scroll Back to Top">
    <a href="#" title="top"><img src="/resources/images/a_top.gif"></a>
</div>
<!--//기본버튼(Right 정렬) :e -->
<!-- togglemenu -->
<script type="text/javascript">

    //validation_check
    $(document).ready(function () {
        password_validation_check($("#confirmPasswordInput").val());
        name_validation_check();
        checkEmail($("#permissionMail"));
        //name
        $("#permissionName").keyup(function () {
            name_validation_check();
        });
        //mail
        $("#permissionMail").keyup(function () {
            checkEmail($("#permissionMail"));
        });
        //password
        $("#confirmPasswordInput").keyup(function () {
            password_validation_check($(this).val());
        });
        $("#newPasswordInput").keyup(function () {
            password_validation_check($("#confirmPasswordInput").val());
        });
        //search
        $("#searchInstRepoUserId").keyup(function (event) {
            if (13 === event.which) {
                searchInstRepoUserId();
            }
        });
    });

    //[1-1]name
    function name_validation_check() {
        var nameNotConfirmedAlert = $("#nameNotConfirmedAlert");
        var name = $("#permissionName").val();
        var r = new RegExp("[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]");
        if (name.length >= 2 && r.test(name)) {
            nameNotConfirmedAlert.hide();
            return true;
        } else {
            nameNotConfirmedAlert.show();
            return false;
        }
    }

    //[1-2]email
    function checkEmail(email) {
        var emailNotConfirmedAlert = $("#emailNotConfirmedAlert");
        var checkVal = validEmail(email.val())? emailNotConfirmedAlert.show(): emailNotConfirmedAlert.hide() ;
        return checkVal;
    }

    function validEmail(email) {
        if(null === email || email ==="") return false;
        var r = new RegExp("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
        return (email.match(r) === null) ? true : false;
    }

    //[1-3]password
    function password_validation_check(confimPassword) {
        var result = true;
        var passwordNotConfirmedAlert = $("#passwordNotConfirmedAlert");
        if (confimPassword === "" || $("#newPasswordInput").val() === "" || $("#newPasswordInput").val() === null || confimPassword === null) {
            passwordNotConfirmedAlert.hide();
            return true;
        }
        if (confimPassword !== $("#newPasswordInput").val()) {
            passwordNotConfirmedAlert.show();
            return false;
        } else {
            passwordNotConfirmedAlert.hide();
            return true;
        }
    }

    //[1-4]search
    function searchInstRepoUserId() {
        $('#SrchPermissionUserList').children().remove();
        var searchId =$("#searchInstRepoUserId").val();
        if(searchId ==="" || searchId ===null){
            popupAlertClick("검색어는 한자이상 입력하세요.");
            return;
        }
        var url = "/user/permission/search/instanceId/" + $("#searchInstRepoUserId").val();
        procCallAjax('get', url, null, searchInstRepoUserIdCallBack);
    }


    //searchCALLBACK
    function searchInstRepoUserIdCallBack(data) {
        $("#SrchPermissionUser").text(data.rtnList.length);
        if (data.rtnList === null || data.rtnList.length === 0) {
            var varHeadHtml = '<li>조회된 사용자가 없습니다.</li>';
            $('#SrchPermissionUserList').append(varHeadHtml);
        } else {
            var rtnList = data.rtnList;
            for (var i = 0; i < rtnList.length; i++) {
                var varHeadHtml = '<li style="height: 25px"><span style="display:block; width: 300px;">'+rtnList[i].userId+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
                if (rtnList[i].userPermissionNo !== "") {
                    varHeadHtml = varHeadHtml + '<button  type="button" class="btn btn-default" onclick="deletePermission(\''+ rtnList[i].no +'\')\">'
                        + '<span class="glyphicon glyphicon-minus"></span></button>';
                } else {
                    varHeadHtml = varHeadHtml + '<button  type="button" class="btn btn-default" '
                        + 'onclick=\"insertPermission(\'' + rtnList[i].userId + '\',\'' + rtnList[i].userName + '\',\'' + rtnList[i].userEmail + '\')\">'
                        + '<span class="glyphicon glyphicon-plus"></span></button>';
                }
                varHeadHtml = varHeadHtml + '</span></li>';
                $('#SrchPermissionUserList').append(varHeadHtml);
            }
        }
    }

    //createUsers
    var instanceCreateUser = function () {
        var user = "";
        var url = "/user/instanceAddUser.do";
        var reqParam =
            {   "userId":$("#permissionName").val()
                ,"repoRole":"owner"
                ,"createrYn":"N"
                ,"displayName" :$("#PermissionDisplayName").val()
                ,"mail":$("#permissionMail").val()
                ,"desc":$("#name_desc").val()
                ,"password":$("#confirmPasswordInput").val()
                ,"type":"xml"
                ,"acitve":true
            };
        procCallAjax("post", url, reqParam, instanceCreateUserCallBack);
    };


    //CALLBACK
    var instanceCreateUserCallBack = function (data) {
        if(data.message !=null){
            popupAlertClick(data.message);
            return;
        }
        if(data.error !=null){
            popupAlertClick("사용자 추가가 실패되었습니다.");
            return;
        }
        console.log("::[2]Callback inviteUser ::");

        if(data.rtnUser.name!=null){
            var name = data.rtnUser.name;
            procPopupAlert("["+name+"]사용자 생성이 완료되었습니다.",'$("#permissionList").submit()','return;');
        }
    };

    $("#buttonCreateOnclick").text("생성");
    $("#buttonCreateOnclick").click(function (event) {
    //function createUserBeforeValid() {
        var nameNotConfirmedAlert = $("#nameNotConfirmedAlert");
        var name = $("#permissionName").val();
        if (!name_validation_check()) {
            popupAlertClick("형식에 맞는 아이디를 사용하세요.");
            return;
        }
        if (!password_validation_check($("#confirmPasswordInput").val())) {
            popupAlertClick("패스워드를 확인하세요.");
            return;
        }
        if (!checkEmail($("#permissionMail"))) {
            popupAlertClick("형식에 맞는 이메일을 사용하세요.");
            return;
        }
        instanceCreateUser();
    });

</script>
<!--//select 스크립트-->
