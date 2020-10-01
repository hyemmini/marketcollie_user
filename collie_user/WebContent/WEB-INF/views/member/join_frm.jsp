<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="http://211.238.142.36/jsp_prj/common/css/main.css">
<title>Insert title here</title>
<style type="text/css">
	#wrap{ width:900px; height:1200px; margin:0px auto; }
	#header{ width:900px; height:180px; }
	#headerTop{ width:900px; height:140px; position:relative; background:#FFFFFF url("http://211.238.142.36/jsp_prj/common/images/header_bg.png") }
	#mainText{ font-family: 고딕,godic,Sans-Serif; font-size:30px; font-weight:bold; width:140px; height:50px; margin:0px auto; padding-top:20px; }
	#naviBar{ width:900px; height:60px; margin-top:10px }
	#container{ width: 900px; height:800px; position:relative; margin-top: 30px}
	#footer{ width: 900px; height:120px; position:relative; }
	#footerLogo{ width:170px; height:60px; margin-left:10px; margin-top:10px; }
	#footerContent{ width:700px; height:100px; margin-left:600px; margin-top:10px; font-family:고딕,godic; font-size:14px; text-align: right; margin-right:20px;}
</style>  
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<!-- Google CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
$(function(){
	
	$("#chkId").click(function(){
		var id = $("#id").val();
	  if( id.length > 6 ){
			$.ajax({
				url : "id_chk_ajax.do",
				type : 'get',
				data: "id="+id,
				dataType:"json",
				error : function() {
						console.log("실패");
				},
				success : function( json ) {
					
					if ( json.id_dup_result ) {
							// 아이디가 중복되는 문구
							$("#id_check").html("중복된아이디");
						}else{
							// 아이디가 중복되는 문구
							$("#id_check").html("사용 가능한 아이디 입니다. ");
						}//end if
					}//success
				});//ajax
	}//end if
	});//click
	
	$("#chkEmail").click(function(){
			var email = $("#email").val();
		if(email.length > 3){
		$.ajax({
			url : "email_chk_ajax.do",
			type : "get",
			data : "email="+email,
			dataType : "json",
			error : function( ){
				alert("errror가 발생했습니다.");
			},
			success : function( jsonObj ){
					if( jsonObj.email_dup_result ){
						$("#email_chk").html(" 중복된 이메일 입니다. ");
					}else{
						$("#email_chk").html(" 사용 가능한 이메일 입니다. ")
					}//end if
				}//success
			});//ajax
		}//end if
		});//click
		
		$("#joinBtn").click(function(){
			
			if($("#id").val().trim()==""){
				alert("아이디를 입력해 주세요");
				$("#id").focus();
				return;
			}
			
			if($("#pass").val().trim()==""){
				alert("비밀번호를 입력해주세요");
				$("#pass").focus();
				return;
			}
			
		      if($("#pass").val().replace(/[0-9A-Za-z]/g, "") != ""){
		          alert("비밀번호는 숫자 또는 영문(대,소문자)만 가능합니다.");
		          $("#pass").val("");
		          return;
		       }
		      
		      if($("#passCheck").val().trim()==""){
					alert("비밀번호 확인칸을 입력해주세요");
					$("#passCheck").focus();
					return;
				}
				
					var pass = ($("#pass").val());
					var passCheck = ($("#passCheck").val());
					
				if(pass!=passCheck){
					alert("비밀번호화 비밀번호확인이 일치하지 않습니다.");
					return;
				}
		      
		      if($("#name").val().trim()==""){
					alert("이름을 입력해주세요");
					$("#name").focus();
					return;
				}
		      
		      if($("#name").val().replace(/[ㄱ-힣]/g, "") != ""){
		          alert("이름은 한글만 가능합니다");
		          $("#name").val("");
		          return;
		       }
		
			if($("#email").val().trim()==""){
				alert("이메일을 입력해주세요");
				$("#email").focus();
				return;
			}
			
			if($("#phone1").val().trim()==""){
				alert("연락처를 입력해주세요");
				return;
			}
			
			if($("#phone2").val().trim()==""){
				alert("연락처를 입력해주세요");
				return;
			}
			
			if($("#phone3").val().trim()==""){
				alert("연락처를 입력해주세요");
				return;
			}
			
			if($("#phone1").val().replace(/[0-9]/g, "") != ""){
		          alert("연락처는 숫자만 입력 가능합니다.");
		          $("#phone1").val("");
		          return;
		       }
			
			if($("#phone2").val().replace(/[0-9]/g, "") != ""){
		          alert("연락처는 숫자만 입력 가능합니다.");
		          $("#phone2").val("");
		          return;
		       }
			
			if($("#phone3").val().replace(/[0-9]/g, "") != ""){
		          alert("연락처는 숫자만 입력 가능합니다.");
		          $("#phone3").val("");
		          return;
		       }
			
			if($("#addr").val().trim()==""){
				alert("주소를 입력해 주세요");
				$("#addr").focus();
				return;
			}
			
			if($("#addr_detail").val().trim()==""){
				alert("상세주소를 입력해 주세요");
				$("#addr_detail").focus();
				return;
			}
			
			
			$("#joinFrm").submit();
		});//click
	
});//ready

function sample4_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
           // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

           // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
           // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
           var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
           var extraRoadAddr = ''; // 도로명 조합형 주소 변수

           // 법정동명이 있을 경우 추가한다. (법정리는 제외)
           // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
           if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
               extraRoadAddr += data.bname;
           }
           // 건물명이 있고, 공동주택일 경우 추가한다.
           if(data.buildingName !== '' && data.apartment === 'Y'){
              extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
           }
           // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
           if(extraRoadAddr !== ''){
               extraRoadAddr = ' (' + extraRoadAddr + ')';
           }
           // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
           if(fullRoadAddr !== ''){
               fullRoadAddr += extraRoadAddr;
           }

           // 우편번호와 주소 정보를 해당 필드에 넣는다.
           console.log(data.zonecode);
           console.log(fullRoadAddr);
           
           
           $("[name=addr1]").val(data.zonecode);
           $("[name=addr2]").val(fullRoadAddr);
           
           document.getElementById('zipcode').value = data.zonecode; //5자리 새우편번호 사용
           document.getElementById('addr').value = fullRoadAddr;
       }
    }).open();
}

	

</script>
</head>
<body>
<div id="wrap">
	<div id="header">
	<jsp:include page="../common/header.jsp" />
	</div>
	
	<div id="container">
	<div style="margin: 0 auto">
	<div style="border-bottom: 3px solid #333; text-align: center; font-size: 35px">회원가입</div>
	<div></div>
	
	
	<form action="join_process.do" method="post" id="joinFrm">
		<div class="form-row" style="margin-top: 20px">
		    <div class="form-group col-md-6">
		      <label for="inputEmail4">아이디</label>
		      <input type="email" class="form-control" name="id" id="id" placeholder="6자이상의 영문 혹은 영문 숫자를 조합">
		    </div>
		    <input type="button" style="height:36px; margin-top: 32px; margin-left: 10px; background-color: white; color: black; " id="chkId" value="중복확인"/>
	    </div>
	    <div id="id_check"> </div>
	    <div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="inputPassword4">비밀번호</label>
		      <input type="password" class="form-control" id="pass" name="pass" maxlength="10" placeholder="비밀번호를 입력해주세요">
		    </div>
	  	</div>
	    <div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="inputPassword4">비밀번호 확인</label>
		      <input type="password" class="form-control" id="passCheck" placeholder="비밀번호를 한번 더 입력해주세요" maxlength="10" >
		    </div>
	  	</div>
	    <div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="inputPassword4">이름</label>
		      <input type="email" class="form-control" name="name" id="name" placeholder="이름을 입력해주세요">
		    </div>
	  	</div>
	    <div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="inputPassword4">이메일</label>
		      <input type="email" class="form-control" name="email" id="email" placeholder="예:collie@collie.com">
		    </div>
		    <input type="button" style="height:36px; margin-top: 32px; margin-left: 10px; background-color: white; color: black;" id="chkEmail" value="중복확인"/>
	  	</div>
	  	<div id="email_chk"></div>
		 <label for="inputPassword4">휴대전화</label><br/>
	  	<div class="form-inline">
		  	<div class="form-group">
				<input type="email" class="form-control" style="width: 80px" maxlength="3"  id="phone1" name="phone1">
			</div>
		  	<div class="form-group">
				<label for="email">&nbsp;-&nbsp;</label>
				<input type="email" class="form-control"  style="width: 100px" id="phone2" maxlength="4" name="phone2">
			</div>
		  	<div class="form-group">
				<label for="email">&nbsp;-&nbsp;</label>
				<input type="email" class="form-control" style="width: 100px"  id="phone3" maxlength="4" name="phone3">
			</div>
	  	</div>
	  	<br/>
	  	<div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="inputPassword4">우편번호</label>
		      <input type="email" class="form-control" name="zipcode" id="zipcode" placeholder="우편번호" readonly="readonly">
		    </div>
		    <input type="button" value="주소검색"  onclick="sample4_execDaumPostcode()" style="height:36px; margin-top: 32px; margin-left: 10px; background-color: white; color: black;" id="zipBtn" name="zipBtn"/>
	  	</div>
		<div class="form-row">
		    <div class="form-group col-md-6">
		      <label for="inputPassword4">주소</label>
		      <input type="email" class="form-control" name="addr" id="addr" readonly="readonly">
		    </div>
	  	</div>
	  	<div class="form-row" style="border-bottom: 3px solid #333">
		    <div class="form-group col-md-6">
		      <label for="inputPassword4">상세주소</label>
		      <input type="email" class="form-control" name="addr_detail" id="addr_detail">
		    </div>
	  	</div>
	    <div style="text-align: center ; margin-top: 30px"><button type="submit" class="btn btn-primary" style="zoom:1.2; background-color: white; color: black; border-color: black;" value="회원가입" id="joinBtn">회원가입</button></div>
	  </form>
  	</div>
	</div>
</div>

	<div id="footer">
		<jsp:include page="../common/footer.jsp" />
	</div>
	
</body>
</html>