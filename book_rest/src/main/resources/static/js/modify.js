const form = document.querySelector("#actionForm");

document.querySelector(".btn-danger").addEventListener("click", () => {
  if (!confirm("렬루 삭제함?")) return;
  form.action = "/book/delete";
  form.submit();
});
