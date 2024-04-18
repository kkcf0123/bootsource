//제목 클릭시 a태그 기능 중지
// data - id 값 가져오기

document.querySelector("tbody").addEventListener("click", (e) => {
  e.preventDefault();

  const target = e.target;
  fetch("http://localhost:8080/read/${target.dataset.id}")
    .then((response) => response.json())
    .then((data) => {
      console.log(data);
      document.querySelector("#category").value = data.categoryName;
      document.querySelector("#title").value = data.title;
      document.querySelector("#publisher").value = data.publisher;
      document.querySelector("#writer").value = data.writer;
      document.querySelector("#price").value = data.price;
      document.querySelector("#salePrice").value = data.salePrice;
    });
});
