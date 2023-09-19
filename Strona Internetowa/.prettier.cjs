module.exports = {
	trailingComma: "es5",
	tabWidth: 2,
	semi: true,
	singleQuote: true,
	printWidth: 80,
	endOfLine: "auto",

	plugins: ["prettier-plugin-svelte", "prettier-plugin-tailwindcss"],
	overrides: [{ files: "*.svelte", options: { parser: "svelte" } }],

	svelteSortOrder: "options-styles-scripts-markup",
	svelteStrictMode: true,
	svelteAllowShorthand: true,
};
