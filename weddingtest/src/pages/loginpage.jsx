export default function LoginPage() {
    return (
      <div className="min-h-screen w-screen flex items-center justify-center bg-gray-200">
        <div className="w-full sm:max-w-sm md:max-w-md lg:max-w-lg bg-white shadow-md rounded-lg p-6 space-y-6">
          <div className="space-y-4">
            <input
              type="email"
              placeholder="이메일"
              className="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-gray-500"
            />
            <input
              type="password"
              placeholder="비밀번호"
              className="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-gray-500"
            />
            <div className="text-right text-gray-500 text-sm">
              아이디 찾기 / 비밀번호 찾기
            </div>
          </div>
          <div className="mt-6 space-y-4">
            <button className="w-full bg-green-500 text-black py-3 rounded-lg hover:bg-green-600 transition">
              웨돋 로그인
            </button>
            <button className="w-full bg-green-500 text-black py-3 rounded-lg hover:bg-green-600 transition">
              웨돋 회원가입
            </button>
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
  