/**
 * store js
 */


document.addEventListener("DOMContentLoaded", function() {

	//main 목차 그리기
	let sido1 = document.getElementById("sido1");
	var data = {};
	var data2 = {};
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			data = JSON.parse(this.responseText)
		}
	};
	xhttp.open("get", "../js/json/storemap.json", false);
	xhttp.send();
	for (let i = 0; i < data.main.length; i++) {
		let option = document.createElement("option");
		option.innerText = data.main[i];
		option.value = i + 1;
		sido1.appendChild(option)
	}
	var xhttp2 = new XMLHttpRequest();
	xhttp2.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			data2 = JSON.parse(this.responseText)
		}
	};
	xhttp2.open("get", "../js/json/stores.json", false);
	xhttp2.send();
	let storelists = document.getElementById("storelists");
	for (let i = 0; i < data2["강남구"].length; i++) {
		let times = data2["강남구"][i].영업시간 === undefined ? "  " : data2["강남구"][i].영업시간;
		templetes = `
				 <div class="content" onclick="s(this)">
					<h3>매장명 : ${data2["강남구"][i].매장명}</h3>
					<p>전화번호 : ${data2["강남구"][i].전화번호}</p>
					<p>구주소 : ${data2["강남구"][i].구주소}</p>
					<p>신주소 : ${data2["강남구"][i].신주소}</p>
					<p>영업시간 : ${times}</p>		
				</div>			
				`
		storelists.innerHTML += templetes;
	}

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



//main도시면 선택 후 inputSubLocal실행 메서드
function selectMain() {

	let index = sido1.value;
	let str = sido1.childNodes[index].childNodes[0].textContent
	inputSubLocal(str)
	selectSub()
}


//sub 선택시 작동하는 메서드
function selectSub() {	
	let sido1 = document.getElementById("sido1");
	let indexValue = sido1.value;
	let arrayFile =["","","stores","busan"]
	let sido2 = document.getElementById("sido2");
	let index = sido2.value;
	let str = sido2.childNodes[index - 1].childNodes[0].textContent
	let storelists = document.getElementById("storelists");
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			data = JSON.parse(this.responseText)
			storelists.innerHTML = ""
			let templetes = "";
			if (str != "") {

				for (let i = 0; i < data[str].length; i++) {
					let times = data[str][i].영업시간 === undefined ? "  " : data[str][i].영업시간;
					templetes = `
				 <div class="content" onclick="s(this)">
					<h3>매장명 : ${data[str][i].매장명}</h3>
					<p>전화번호 : ${data[str][i].전화번호}</p>
					<p>구주소 : ${data[str][i].구주소}</p>
					<p>신주소 : ${data[str][i].신주소}</p>
					<p>영업시간 : ${times}</p>		
				</div>			
				`
					storelists.innerHTML += templetes;
				}

			} else {
				for (let i = 0; i < data["서울"].length; i++) {
					let times = data["서울"][i].영업시간 === undefined ? "  " : data["서울"][i].영업시간;
					templetes = `
				 <div class="content" onclick="s(this)">
					<h3>매장명 : ${data["서울"][i].매장명}</h3>
					<p>전화번호 : ${data["서울"][i].전화번호}</p>
					<p>구주소 : ${data["서울"][i].구주소}</p>
					<p>신주소 : ${data["서울"][i].신주소}</p>
					<p>영업시간 : ${times}</p>		
				</div>			
				`
					storelists.innerHTML += templetes;
				}

			}
		}

	};
	xhttp.open("GET", "../js/json/"+arrayFile[indexValue]+".json", true);
	xhttp.send();

}



//sub도시명 그리기 메서드
function inputSubLocal(str) {

	var sub_data = {};
	let sido2 = document.getElementById("sido2");
	//sub 목차 불러오기
	var subxhttp = new XMLHttpRequest();
	subxhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			sub_data = JSON.parse(this.responseText)
			while (sido2.hasChildNodes()) {
				sido2.removeChild(sido2.firstChild);
			}

			if (str != "시/도") {
				for (let i = 0; i < sub_data[str].length; i++) {
					let option = document.createElement("option");
					option.innerText = sub_data[str][i];
					option.value = i + 1;
					sido2.appendChild(option)
				}
			} else {
				let option = document.createElement("option");
				option.innerText = "시/구/군";
				sido2.appendChild(option)
			}
		}

	};
	subxhttp.open("GET", "../js/json/city.json", false);
	subxhttp.send();
}