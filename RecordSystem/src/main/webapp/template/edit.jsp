<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/note.css" />
<script src="<%=request.getContextPath()%>/js/note.js"></script>
<title>添加记录</title>
</head>
<body>
	<div class="contain_note">
		<div class="head_input">
			<div class="form">
				<form>
					<input type="text" id="txt_note" /> <input type="button"
						id="btn_add" value="添加便签" />
				</form>
			</div>
		</div>
		<div class="body_notes">
			<ul id="note">
			</ul>
		</div>
	</div>
	<div id="background">
		<img id="img_background" width="100%" height="100%" />
	</div>
</body>
</html>