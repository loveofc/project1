
// 슬라이드 구현
//li를 모두 가져 온 뒤 배열의 순서를 계속 바꿔주어 구현하고자 한다.
document.addEventListener("DOMContentLoaded", function() {

	setInterval(slideFunc,5000)

	
	
})

function slideFunc() {
	let ul_ = document.querySelectorAll(".contentsList")[0];
	let lis_ = document.querySelectorAll(".list");
	let stringList = [];
	let shiftElement;

	for (let i = 0; i < lis_.length; i++) {
		stringList[i] = lis_[i];
	}


	shiftElement = stringList.shift();
	ul_.removeChild(ul_.firstChild)
	stringList.push(shiftElement)
	ul_.append(shiftElement)

}
 //슬라이드 구현 끝


