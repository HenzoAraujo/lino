const modal = document.querySelector("#modal");
const openModal = document.querySelector("#openModal");
const preventModal = document.querySelector("#preventModal")

openModal.addEventListener("click", () => {
    modal.classList.add("flex");
    modal.classList.remove("hidden");
})
modal.addEventListener("click", () => {
    modal.classList.add("hidden");
    modal.classList.remove("flex");
})
preventModal.addEventListener("click", (e) => {
    e.stopPropagation();
})
document.addEventListener("keydown", (e) => {
    if (e.key === "Escape") {
        modal.classList.add("hidden");
        modal.classList.remove("flex");
    }
})