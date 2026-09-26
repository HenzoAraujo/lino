const divButtons = document.querySelector("#divButtons");

const buttons = [
    { id: "openThemeModal", name: "Criar" },
    { name: "Listar", href: "/home" }
];

buttons.forEach((buttons) => {
    divButtons.innerHTML += `<a id=${buttons.id} class="relative cursor-pointer">${buttons.name}</a>`;
})

const themeModal = document.querySelector("#themeModal");
const openThemeModal = document.querySelector("#openThemeModal");
const preventThemeModal = document.querySelector("#preventThemeModal")

openThemeModal.addEventListener("click", () => {
    themeModal.classList.add("flex");
    themeModal.classList.remove("hidden");
})
themeModal.addEventListener("click", () => {
    themeModal.classList.add("hidden");
    themeModal.classList.remove("flex");
})
preventThemeModal.addEventListener("click", (e) => {
    e.stopPropagation();
})
document.addEventListener("keydown", (e) => {
    if (e.key === "Escape") {
        themeModal.classList.add("hidden");
        themeModal.classList.remove("flex");
    }
})