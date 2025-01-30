export default function Button1({ children, onClick = () => {} }) {
  return (
    <button
      className="w-full bg-green-500 text-black py-3 rounded-lg hover:bg-green-600 transition"
      onClick={onClick}
    >
      {children}
    </button>
  );
}
