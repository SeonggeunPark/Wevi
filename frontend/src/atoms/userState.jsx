import { atom } from "recoil";

export const userState = atom({
  key: "userState",
  default: {
    key: false,
    default: JSON.parse(localStorage.getItem("user")) || null,
  },
});
