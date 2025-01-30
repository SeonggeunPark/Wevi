import { useState } from "react";
import Button1 from "../components/Buttons/Button1";

// useref를 써서 불필요한 리렌더링 방지
export default function LoginPage() {
  const [enteredEmail, setEnteredEmail] = useState("");
  const [enteredPassword, setEnteredPassword] = useState("");

  function handleLogin(event) {
    event.preventDefault();
    console.log(enteredEmail);
    console.log(enteredPassword);
  }
  // 이메일 입력 변화 감지
  function handleEmailChange(event) {
    setEnteredEmail(event.target.value);
  }
  // 비밀번호 입력 변화 감지
  function handlePasswordChange(event) {
    setEnteredPassword(event.target.value);
  }

  return (
    <div className="min-h-screen w-screen flex items-center justify-center bg-gray-200">
      <div className="w-full sm:max-w-sm md:max-w-md lg:max-w-lg bg-white shadow-md rounded-lg p-6 space-y-6">
        <form className="space-y-4" onSubmit={handleLogin}>
          <input
            id="email"
            type="email"
            name="email"
            onChange={handleEmailChange}
            value={enteredEmail}
            placeholder="이메일"
            className="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-gray-500"
          />
          <input
            id="password"
            type="password"
            name="password"
            onChange={handlePasswordChange}
            value={enteredPassword}
            placeholder="비밀번호"
            className="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-gray-500"
          />
          <div className="text-right text-gray-500 text-sm">
            아이디 찾기 / 비밀번호 찾기
          </div>
        </form>
        <div className="mt-6 space-y-4">
          <Button1 onClick={handleLogin}>웨돋 로그인</Button1>
          <Button1 onClick={handleLogin}>웨돋 회원가입</Button1>
          <div className="text-center text-green-500 text-sm font-bold">
            기업이신가요?
          </div>
          <div className="text-center text-gray-500">소셜 로그인</div>
          <button className="w-full bg-yellow-400 text-black py-3 rounded-lg flex items-center justify-center hover:bg-yellow-500 transition">
            <span className="mr-2">💬</span> 카카오로 시작하기
          </button>
        </div>
      </div>
    </div>
  );
}
