//Модальные формы со страницы контрагентов
const modalAddGuide = document.getElementById("modalAddGuide");
const modalAddCity = document.getElementById("modalAddCity");
const modalAddExcursion = document.getElementById("modalAddExcursion");
const modalDeleteGuide = document.getElementById("modalDeleteGuide");
const modalDeleteCity = document.getElementById("modalDeleteCity");
const modalDeleteExcursion = document.getElementById("modalDeleteExcursion");
const modalChangeGuide = document.getElementById("modalChangeGuide");
const modalChangeCity = document.getElementById("modalChangeCity");
const modalChangeExcursion = document.getElementById("modalChangeExcursion");

//Открытие форм
function openForm(modal) {
    clearInputs(modal);
    modal.style.display = "block";
}

//Закрытие форм
function closeForm(modal) {
    modal.style.display = "none";
}

//Очистить все поля формы
function clearInputs(modal) {
    let inputs = modal.querySelectorAll('input[type="text"]');
    inputs.forEach(function (item) {
        item.value = "";
    })
}
