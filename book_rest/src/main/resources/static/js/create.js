// form submit 클릭 시 submit 기능 중지
// form 내용 가져오기 -> js object 생성

document.querySelector("submit").addEventListener("click", (e) => {
  e.preventDefault();

  const target = e.target;
});
