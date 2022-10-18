document.addEventListener("DOMContentLoaded", function() {
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level: 2// 지도의 확대 레벨
		};

	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption);
	var geocoder = new kakao.maps.services.Geocoder();
	geocoder.addressSearch('경기도 오산시 동부대로 436번길 55-18', function(result, status) {

		// 정상적으로 검색이 완료됐으면 
		if (status === kakao.maps.services.Status.OK) {

			var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

			// 결과값으로 받은 위치를 마커로 표시합니다
			var marker = new kakao.maps.Marker({
				map: map,
				position: coords
			});

			// 인포윈도우로 장소에 대한 설명을 표시합니다
			var infowindow = new kakao.maps.InfoWindow({
				content: '<div style="width:150px;text-align:center;padding:6px 0;">본사</div>'
			});
			infowindow.open(map, marker);

			// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			map.setCenter(coords);
		}
	});
})

function selectMain(){
	let main = document.getElementById("sido1")
	let value = main.value;
	let form = document.createElement("form");
	let input = document. createElement("input");
	input.value = value;
	input.name = "sido";
	form.append(input)
	form.action = "http://localhost:9000/nav/map";
	form.method ="post";
	document.body.append(form);
	form.submit();
}

function selectSub(){
	/////////////
	let main = document.getElementById("sido1")
	let value = main.value;
	let input = document. createElement("input");
	input.value = value;
	input.name = "sido";

	
	//////////
	let main2 = document.getElementById("sido2")
	let value2 = main2.value;
	let form2 = document.createElement("form");
	let input2 = document. createElement("input");
	input2.value = value2;
	input2.name = "sido2";
	form2.append(input)
	form2.append(input2)
	form2.action = "http://localhost:9000/nav/map";
	form2.method ="post";
	document.body.append(form2);
	form2.submit();
}

//클릭시 위치 변경
function s(vlaue) {
	let addr = vlaue.childNodes[7].textContent;
	let startIndex = addr.indexOf("(") + 1;
	let lastIndex = addr.indexOf(")");
	let storeName = vlaue.childNodes[1].textContent;
	addr = addr.substring(startIndex, lastIndex);
	console.log()
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level: 3 // 지도의 확대 레벨
		};

	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption);
	var geocoder = new kakao.maps.services.Geocoder();
	geocoder.addressSearch(addr, function(result, status) {

		// 정상적으로 검색이 완료됐으면 
		if (status === kakao.maps.services.Status.OK) {

			var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

			// 결과값으로 받은 위치를 마커로 표시합니다
			var marker = new kakao.maps.Marker({
				map: map,
				position: coords
			});

			// 인포윈도우로 장소에 대한 설명을 표시합니다
			var infowindow = new kakao.maps.InfoWindow({
				content: `<div style="width:150px;text-align:center;padding:6px 0;">${storeName}점</div>`
			});
			infowindow.open(map, marker);

			// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
			map.setCenter(coords);
		}
	});
}