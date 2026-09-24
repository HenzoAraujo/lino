const divButtons = document.querySelector("#divButtons");

const buttons = [
    { name: "Criar", href: "/pagina" },
    { name: "Listar", href: "/home" }
];

buttons.forEach((buttons) => {
    divButtons.innerHTML += `<a class="relative" href=${buttons.href}>${buttons.name}</a>`;
})