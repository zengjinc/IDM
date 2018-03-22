var _LoadingHtml = "<div id='loadingDiv' style='position: absolute;left: 50%;top: 50%;margin-left: -50px;margin-top: -50px;text-align: center;z-index:100;'><img src='img/loading.svg' /></div>";

// 呈现loading效果
document.write(_LoadingHtml);

// 监听加载状态改变
document.onreadystatechange = completeLoading;

// 加载状态为complete时移除loading效果
function completeLoading() {
	if (document.readyState == "complete") {
		$("#loadingDiv").fadeOut(1000);
	}
}