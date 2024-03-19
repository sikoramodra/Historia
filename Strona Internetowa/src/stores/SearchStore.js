import { writable } from "svelte/store";

export const createSearchStore = (data) => {
	const { subscribe, set, update } = writable({
		data: data,
		filtered: data,
		search: "",
	});

	return {
		subscribe,
		set,
		update,
	};
};

export const searchHandler = (store) => {
	const polishToEnglishMap = {
		ą: "a",
		ć: "c",
		ę: "e",
		ł: "l",
		ń: "n",
		ó: "o",
		ś: "s",
		ź: "z",
		ż: "z",
	};

	if (store.search.length > 0) {
		const searchTerm = store.search.toLowerCase().replace(/[ąćęłńóśźż]/g, (match) => polishToEnglishMap[match] || match) || "";
		store.filtered = store.data.filter((item) => {
			return item.searchTerms
				.toLowerCase()
				.replace(/[ąćęłńóśźż]/g, (match) => polishToEnglishMap[match] || match)
				.includes(searchTerm);
		});
	}
};
