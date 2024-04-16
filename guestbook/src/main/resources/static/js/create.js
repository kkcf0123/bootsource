// const form = document.querySelector("form");
// form.addEventListener("submit", (e) => {
//   e.preventDefault(); // submit 중지

//   const category = document.querySelector("#categoryName");
//   const title = document.querySelector("#title");
//   const publisher = document.querySelector("#publisherName");
//   const writer = document.querySelector("#writer");
//   const price = document.querySelector("#price");
//   const salePrice = document.querySelector("#salePrice");
// //
//   if (category.value == "선택") {
//     alert("category를 확인해 주세요.");
//     return;
//   } else if (!title.value) {
//     alert("title을 확인해 주세요");
//     title.focus();
//     return;
//   } else if (publisher.value == "선택") {
//     alert("publisher를 확인해 주세요.");
//     return;
//   } else if (!writer.value) {
//     alert("writer를 확인해 주세요");
//     writer.focus();
//     return;
//   } else if (!price.value || isNaN(price.value)) {
//     alert("price를 확인해 주세요");
//     price.focus();
//     return;
//   } else if (!salePrice.value || isNaN(salePrice.value)) {
//     salePrice = 0;
//   }

//   form.submit();
// });
