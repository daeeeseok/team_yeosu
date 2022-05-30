<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<!DOCTYPE html>
<html lang="ko">
<head>

    <jsp:include page="../common/admin_head.jsp"/>

    <title>여수어때 : 펜션정보수정</title>
</head>
<security:csrfMetaTags/>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <jsp:include page="../common/admin_sidebar.jsp"/>
		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
		
		    <!-- Main Content -->
		    <div id="content">
		        <jsp:include page="../common/admin_nav.jsp"/>
		    
				<div class="p-5 m-5 border bg-white">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">펜션 등록</h1>
                            </div>
                            <form class="user" method="post">
                                <div class="form-group">
                                	<label for="name">펜션 이름</label>
                                    <input type="text" class="form-control" id="name" name="name" >
                                    <small class="text-muted"></small>
                                </div>
                                
                                <div class="form-group">
									<label class="text-black d-block" for="address">펜션 주소</label>
									<input type="text" class="form-control" id="address" name="address" required readonly>
									<button type="button" class="btn btn-primary float-right" id="btnSearchAddr">검색</button>
									<input type="hidden" id="latitude" name="latitude">
									<input type="hidden" id="longitude" name="longitude">
									<!-- <div id="map" style="width:500px;height:350px;margin:0 auto; border:1px solid; display:none"></div> -->
								</div>
								  
                                <div class="form-group">
                                	<label for="comments">사장님한마디</label>
                                    <textarea class="form-control" id="comments" name="comments" ></textarea>
                                </div>
                                <div class="form-group">
                                	<label for="form-select category">펜션 유형</label>
                                	<select class="form-select" id="category" name="category">
                                		<option value="1">펜션</option>
                                		<option value="2">풀빌라</option>
                                	</select>
                                </div>
                                <hr>
                                <div class="form-group filter">
                                	<label for="form-select public">공용시설</label>
                                	<div class="form-select" id="public" >
                                		<input type="checkbox" id="footVolleyballCourt" name="footVolleyballCourt"><label for="footVolleyballCourt">족구장</label>
										<input type="checkbox" id="karaoke" name="karaoke"><label for="karaoke">노래방</label>
										<input type="checkbox" id="convenienceStore" name="convenienceStore"><label for="convenienceStore">편의점</label>
										<input type="checkbox" id="parkingLot" name="parkingLot"><label for="parkingLot">주차장</label>
										<input type="checkbox" id="seminarRoom" name="seminarRoom"><label for="seminarRoom">세미나실</label>
										<input type="checkbox" id="bbq" name="bbq"><label for="bbq">바베큐</label>
										<input type="checkbox" id="restaurant" name="restaurant"><label for="restaurant">식당</label>
                                	</div>
                                	<hr>
                                	<label for="form-select internal">내부시설</label>
                                	<div class="form-select" id="internal" >
										<input type="checkbox"  id="wifi" name="wifi"><label for="wifi">와이파이</label>
										<input type="checkbox"  id="tv" name="tv"><label for="tv">TV</label>
										<input type="checkbox"  id="airConditioner" name="airConditioner"><label for="airConditioner">에어컨</label>
										<input type="checkbox"  id="miniBar" name="miniBar"><label for="miniBar">미니바</label>
										<input type="checkbox"  id="bathTub" name="bathTub"><label for="bathTub">욕조</label>
										<input type="checkbox"  id="refrigerator" name="refrigerator"><label for="refrigerator">냉장고</label>
                                	</div>
                                	<hr>
                                	<label for="form-select other">기타시설</label>
                                	<div class="form-select" id="other" >
										<input type="checkbox" id="pickup" name="pickup"><label for="pickup">픽업</label>
										<input type="checkbox" id="cooking" name="cooking"><label for="cooking">취사가능</label>
										<input type="checkbox" id="breakfast" name="breakfast"><label for="breakfast">조식</label>
										<input type="checkbox" id="freeParking" name="freeParking"><label for="freeParking">무료주차</label>
										<input type="checkbox" id="campfire" name="campfire"><label for="campfire">캠프파이어</label>
                                	</div>
                                </div>
                                <hr>
                                <div class="form-group uploadDiv">
							   		<label class="btn btn-success btn-sm" for="attach">첨부</label>
								    <input type="file" class="form-control d-none" placeholder="attach" id="attach" name="attach" multiple>
							    </div>
								   
							    <ul class="list-group small container px-1 upload-files">

							    </ul>
								   
							    <div class="container pt-3 px-1">
							   	  <div class="row thumbs">
								   	  
							      </div>
						        </div>
						        <hr>
                                <input type="hidden" id="userid" name="userid" value='<security:authentication property="principal.username"/>'> 
                                <button class="btn btn-primary btn-user btn-block" id="btnReg">
                                    Register
                                </button>
                                <security:csrfInput/>
                            </form>
                        </div>

            </div>
            <!-- End of Main Content -->

            <jsp:include page="../common/admin_footer.jsp"/>

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

	<!-- Bootstrap core JavaScript-->
    <script src="/resources/assets/admin/vendor/jquery/jquery.min.js"></script>
    <script src="/resources/assets/admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/resources/assets/admin/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/resources/assets/admin/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="/resources/assets/admin/vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="/resources/assets/admin/js/demo/chart-area-demo.js"></script>
    <script src="/resources/assets/admin/js/demo/chart-pie-demo.js"></script>

    <!-- Page level plugins -->
    <script src="/resources/assets/admin/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="/resources/assets/admin/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="/resources/assets/admin/js/demo/datatables-demo.js"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=53da4885eed3b04fe18257eeb209aa7c&libraries=services"></script>
	<!-- ligthbox2 -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/lightbox2/2.11.3/js/lightbox.min.js" integrity="sha512-k2GFCTbp9rQU412BStrcD/rlwv1PYec9SNrkbQlo6RZCf75l6KcC3UwDY8H5n5hl4v77IDtIPwOk9Dqjs/mMBQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</body>
<script>
	$(function() {
		$("#attach").change(function() {
			var str = "";
			$(this.files).each(function() {
				str += "<p>" + this.name + "</p>";
			})
			$(this).next().html(str);
		})
	}) 		
</script>
<script>
	var headerName = $("meta[name='_csrf_header']").attr("content")
	var token = $("meta[name='_csrf']").attr("content")
	/* var pensionid = '${pension.pensionid}'; */
	/* console.log(headerName)
	console.log(token) */
	/*console.log(pensionid) */
	
	$(document).ajaxSend(function(e, xhr) {
		xhr.setRequestHeader(headerName, token);
	})
	
$(function() {
	
	var validateName = function() {
		var p = $("#name").parent();
		var val = $("#name").val().trim();
		$.ajax("/admin/pensioncheck", {
			data : {name : val}
		}).done(function(result) {
			if(val.length == 0) {
				p.find("small").text("펜션 이름을 입력하세요")
				$("#name").addClass("is-invalid").removeClass("is-valid")
				return
			}
			if(val.length < 4 || val.length > 30) {
				p.find("small").text("4글자 이상 30글자 내외의 펜션 이름을 입력하세요")
				$("#name").addClass("is-invalid").removeClass("is-valid")
				return
			}
			if(result == 1) {
				p.find("small").text("이미 사용중인 펜션 이름입니다")
				$("#name").addClass("is-invalid").removeClass("is-valid")
				return
			}
			else {
				p.find("small").text("")
				$("#name").addClass("is-valid").removeClass("is-invalid")
			}
		})
	}
	
	$("#name").on("focusout", validateName);
	
	var $clone = $(".uploadDiv").clone()
		var regexp = /(.*?)\.(exe||sh||js||jsp)$/
		var maxSize = 1204 * 1024 * 5
		
		function validateFiels(fileName, fileSize) {
			if(fileSize >= maxSize) {
				alert("파일 사이즈 용량 초과")
				return false
			}
			if(regexp.test(fileName)) {
				alert("등록할 수 없는 파일입니다")
				return false
			}
			return true;
		}
	
	lightbox.option({
		resizeDuration: 200,
		wrapAround: true,
		imageFadeDuration: 100
	})
		
		// 파일 첨부 이벤트
		$(".uploadDiv").on("change", ":file", function() {
			var formData = new  FormData()
			console.log(this.files);
			for(var i in this.files) {
				if(!validateFiels(this.files[i].name, this.files[i].size)) {
					return false;
				}
				formData.append("files", this.files[i])
			}
			formData.append("type", "pension")
			
			$.post({
				processData : false,
				contentType : false,
				data : formData,
				url : "/upload",
				dataType : "json"
			})
			.done(function(result) {
				console.log(result)
				$(".uploadDiv").html($clone.html())

				var str = "";
				var thumbStr = "";
				for(var i in result) {
				
					str += '<li class="list-group-item" data-uuid="' + result[i].uuid + '" data-path="' + result[i].path + '" data-image="' + result[i].image + '" data-origin="' + result[i].origin + '" data-ord="' + result[i].ord +'">'
							+ result[i].origin + '</a><button type="button" class="close"><span>&times;</span></button></li>'
					if(result[i].image) {
						var o = {...result[i]};  // clone
						o.uuid = 's_' + o.uuid;
						thumbStr += '	<div class="col-sm-6 col-md4 col-lg-3 col-xl-2" data-uuid="' + result[i].uuid + '" data-path="' + result[i].path + '" data-image="' + result[i].image + '" data-origin="' + result[i].origin + '" data-ord="' + result[i].ord + '">';
						thumbStr += '		<figure class="d-inline-block " style="position:relative; overflow: ">';
						thumbStr += '			<figcaption><button type="button" class="close" style="position: absolute; top:15px; right:8px"><span>&times;</span></button></figcaption>';
						thumbStr += '			<a href="/display?' + $.param(result[i]) + '"data-lightbox="img" data-title="' + o.origin + '"><img alt="" src="/display?' + $.param(o) + '"class="mx-1 my-2 img-thumbnail"></a>';
						thumbStr += '		</figure>';
						thumbStr += '	</div>';
					}
				}
				$(".upload-files").append(str)
				$(".thumbs").append(thumbStr)
			}) 
		})
		
		$("#btnReg").click(function () {
			event.preventDefault()
			
			if($("#name").hasClass("is-invalid")) {
				validateName();
				$("#name").focus();
				return
			}
			
			var str = "";
			var attrArr = ['uuid', 'origin', 'path', 'ord', 'image']
			$(".upload-files li").each(function (i) {
				for(var j in attrArr) {
					attrArr[j]
					str += 
						$("<input>")
						.attr("type", "hidden")
						.attr("name", "attachs[" + i +  "]." + attrArr[j])
						.attr("value", $(this).data(attrArr[j])).get(0).outerHTML + "\n"; 
				}
			})
			console.log(str)
			$(this).closest("form").append(str).submit();
		}) 
	
}) 
</script>
<script>
	$("#btnSearchAddr").click(function() {
	    new daum.Postcode({ // 
	        oncomplete: function(data) {
	            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
	            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
	            console.log(data);
	            new kakao.maps.services.Geocoder().addressSearch(data.jibunAddress, function(result, status){
	            	if(status === kakao.maps.services.Status.OK) {
	     	            $("#address").val(data.jibunAddress);
	     	           	$("#latitude").val(result[0].y);	            		
	     	           	$("#longitude").val(result[0].x);	
	     	           	
	     	           
	     	          /* $("#map").slideDown(200, function() {
	     	        	 var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		            		mapOption = {
		            		    center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		            		    level: 3 // 지도의 확대 레벨
		            		};  
		            		var map = new kakao.maps.Map(mapContainer, mapOption);
		     	           var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

		     	          // 결과값으로 받은 위치를 마커로 표시합니다
		     	          var marker = new kakao.maps.Marker({
		     	              map: map,
		     	              position: coords
		     	          });

		     	          // 인포윈도우로 장소에 대한 설명을 표시합니다
		     	          var infowindow = new kakao.maps.InfoWindow({
		     	              content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
		     	          });
		     	          infowindow.open(map, marker);

		     	          // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		     	          map.setCenter(coords);
	     	          }); */
	            	}
	            })
	        }
	    }).open();
	})
</script>
</html>