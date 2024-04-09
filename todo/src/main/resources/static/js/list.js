// 체크박스 클릭시 id get

// 화면의 중복 요소에 이벤트 작성
// 1) 전체요소 찾기
// document.querySelectorAll('[name="completed"]').addEventListener("click", (e) => {});

// 2) event 전파 => parent ele가 detect
document.querySelector(".list-group").addEventListener("click", (e) => {
  console.log("event가 발생한 대상 value" + e.target.value);
  console.log("event를 감지한 대상" + e.currentTarget);

  // get // script
  // location.href="/todo/update?id="+e.target.value;

  const form = document.querySelector("#completedForm");
  form.querySelector('[name="id"]').value = e.target.value;
  form.submit();
});
