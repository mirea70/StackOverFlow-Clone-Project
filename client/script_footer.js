const data = {
  "STACK OVERFLOW": ["Questions", "Help"],
  PRODUCTS: ["Teams", "Advertising", "Collectives", "Talent"],
  COMPANY: [
    "About",
    "Press",
    "Work Here",
    "Legal",
    "Privacy",
    "Policy",
    "Teams of Service",
    "Contact Us",
    "Cookie Settings",
    "Cookie Policy",
  ],
  "STACK EXCHANGE NETWORK": [
    "Technology",
    "Culture & recreation",
    "Life & arts",
    "Science",
    "Professional",
    "Business",
    "API",
    "Data",
  ],
};

const sns_data = ["Blog", "Facebook", "Twitter", "LinkedIn", "Instagram"];

const footer = document.createElement("div");
footer.id = "footer";

const footer_main_container = document.createElement("div");
footer_main_container.id = "footer_main_container";
const info_container = document.createElement("div");
info_container.id = "info_container";

const logo_container = document.createElement("div");
logo_container.id = "logo_container";

const menu_container = document.createElement("div");
menu_container.id = "menu_container";

const logo = document.createElement("i");
logo.className = "fa-brands fa-stack-overflow fa-2xl";
logo_container.appendChild(logo);

const info_sns_wrapper = document.createElement("ul");
info_sns_wrapper.className = "info_sns_wrapper";

sns_data.forEach((el) => {
  const li = document.createElement("li");
  li.innerText = el;
  info_sns_wrapper.appendChild(li);
});

const info_text_wrapper = document.createElement("p");
info_text_wrapper.className = "info_text_wrapper";

info_text_wrapper.innerText =
  "Site design / logo © 2022 Stack Exchange Inc; user contributions licensed under CC BY-SA. rev 2022.8.23.42893";

info_container.appendChild(info_sns_wrapper);
info_container.appendChild(info_text_wrapper);

const list = (key, arr_value) => {
  const menu_wrapper = document.createElement("div");
  menu_wrapper.className = "menu_wrapper";
  const h5 = document.createElement("h5");
  h5.innerText = key;
  menu_wrapper.appendChild(h5);
  const menu_inside_wrapper = document.createElement("ul");
  menu_inside_wrapper.className = "menu_inside_wrapper";
  arr_value.forEach((el) => {
    const li = document.createElement("li");
    li.innerText = el;
    menu_inside_wrapper.appendChild(li);
  });
  menu_wrapper.appendChild(menu_inside_wrapper);
  return menu_wrapper;
};

const render = (element) => {
  const arr = Object.keys(data);
  arr.forEach((el) => {
    element.appendChild(list(el, data[el]));
  });
  return;
};

render(menu_container);

footer_main_container.appendChild(logo_container);
footer_main_container.appendChild(menu_container);
footer.appendChild(footer_main_container);
footer.appendChild(info_container);

const footer_container = document.getElementById("footer_container");
footer_container.appendChild(footer);
