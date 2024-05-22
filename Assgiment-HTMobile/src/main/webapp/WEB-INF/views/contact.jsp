<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/taglib/tablig.jsp"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
<meta charset="UTF-8">
<meta name="description" content="Fashi Template">
<meta name="keywords" content="Fashi, unica, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Tin Tức</title>
<%@include file="/taglib/css.jsp"%>

</head>
<body>
	<jsp:include page="header.jsp" />
	<!-- Breadcrumb Section Begin -->
	<div class="breacrumb-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="breadcrumb-text">
						<a href="#"><i class="fa fa-home"></i> Trang Chủ</a> <span>Liên
							Hệ</span>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Breadcrumb Section Begin -->

	<!-- Map Section Begin -->
	<div class="map spad">
		<div class="container">
			<div class="map-inner">
				<iframe
					src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d48158.305462977965!2d-74.13283844036356!3d41.02757295168286!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c2e440473470d7%3A0xcaf503ca2ee57958!2sSaddle%20River%2C%20NJ%2007458%2C%20USA!5e0!3m2!1sen!2sbd!4v1575917275626!5m2!1sen!2sbd"
					height="610" style="border: 0" allowfullscreen=""> </iframe>
				<div class="icon">
					<i class="fa fa-map-marker"></i>
				</div>
			</div>
		</div>
	</div>
	<!-- Map Section Begin -->

	<!-- Contact Section Begin -->
	<section class="contact-section spad">
		<div class="container">
			<div class="row">
				<div class="col-lg-5">
					<div class="contact-title">
						<h4>Liên Hệ Chúng Tôi</h4>
						<p>Trái ngược với niềm tin phổ biến, Lorem Ipsum chỉ đơn giản
							là văn bản ngẫu nhiên. Nó bắt nguồn từ một tác phẩm văn học
							Latinh cổ điển từ năm 45 trước Công nguyên, maki tuổi.</p>
					</div>
					<div class="contact-widget">
						<div class="cw-item">
							<div class="ci-icon">
								<i class="ti-location-pin"></i>
							</div>
							<div class="ci-text">
								<span>Địa chỉ :</span>
								<p>Tòa T, Đường số 3, Công viên Phần Mềm Quang Trung</p>
							</div>
						</div>
						<div class="cw-item">
							<div class="ci-icon">
								<i class="ti-mobile"></i>
							</div>
							<div class="ci-text">
								<span>Điện thoại :</span>
								<p>0999999999</p>
							</div>
						</div>
						<div class="cw-item">
							<div class="ci-icon">
								<i class="ti-email"></i>
							</div>
							<div class="ci-text">
								<span>Email:</span>
								<p>htmobile@gmail.com</p>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-6 offset-lg-1">
					<div class="contact-form">
						<div class="leave-comment">
							<h4>Để lại Phản hổi bên dưới</h4>
							<p>Nhân viên của chúng tôi sẽ gọi lại sau và giải đáp thắc
								mắc của bạn.</p>
							<form action="#" class="comment-form">
								<div class="row">
									<div class="col-lg-6">
										<input type="text" placeholder="Tên" id="nameContact" value="${  sessionScope.account.fullname}" disabled="disabled">
									</div>
									<div class="col-lg-6">
										<input type="text" placeholder="Email" id="emailContact" value="${  sessionScope.account.email}" disabled="disabled">
									</div>
									<div class="col-lg-12">
										<textarea placeholder="Phản hồi của bạn" id="contentContact" required="required"></textarea>
										<a type="button" id="btnContact" class="site-btn">Gửi Phản Hồi</a>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Contact Section End -->



	<jsp:include page="footer.jsp" />
	<%@include file="/taglib/js.jsp"%>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
		$("#btnContact").click(function(event) {
			event.preventDefault();
			var content = $("#contentContact").val();
			$.ajax({
				url : "/contact/report?content=" + content,
				type : 'GET',
				success : function(data) {
					alert(data);
					 $("#contentContact").val('');
				},
				error : function(xhr, status, error) {
					alert(" Phản Hồi Thất Bại")
				}
			});
		});
	</script>
</body>
</html>