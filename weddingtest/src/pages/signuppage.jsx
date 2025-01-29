export default function SignUpPage() {
    return (
      <div className="min-h-screen w-screen flex items-center justify-center bg-gray-200">
        <div className="w-screen sm:max-w-sm md:max-w-md lg:max-w-lg  bg-white shadow-md rounded-lg p-6 space-y-6">
          <h1 className="text-xl font-bold text-gray-800">회원가입</h1>
  
          {/* 이메일 입력 */}
          <div className="flex items-center space-x-4">
            <input
              type="email"
              placeholder="이메일"
              className="flex-1 p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-gray-500"
            />
            <button className="bg-blue-500 text-black px-4 py-2 rounded-lg hover:bg-blue-600 transition">
              본인인증
            </button>
          </div>
  
          {/* 비밀번호 입력 */}
          <div className="space-y-4">
            <input
              type="password"
              placeholder="비밀번호"
              className="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-gray-500"
            />
            <input
              type="password"
              placeholder="비밀번호 확인"
              className="w-full p-3 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-gray-500"
            />
          </div>
  
          {/* 안내문구 */}
          <p className="text-center text-gray-600 text-sm">
            본인 인증안되거나 비번 2개 다르면 비활성화
          </p>
  
          {/* 다음 버튼 */}
          <button
            className="w-full bg-gray-300 text-gray-600 py-3 rounded-lg cursor-not-allowed"
            disabled
          >
            다음
          </button>
        </div>
      </div>
    );
  }
  