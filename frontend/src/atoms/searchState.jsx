import { atom } from "recoil";

export const searchState = atom({
  key: "searchState",
  default: {
    key: false,
    default: JSON.parse(localStorage.getItem("user")) || null,
    selectedButton : "",
  },
});
