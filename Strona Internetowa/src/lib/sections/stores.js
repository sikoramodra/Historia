import { writable, derived } from 'svelte/store';

export const isDarkMode = writable(false);

export const appColors = derived(isDarkMode, $isDarkMode => {
	if($isDarkMode) { return { fontColor: '#eeeeee', backgroundColor: '#000000'}; }
	else { return { fontColor: '#000000', backgroundColor: '#f1f1f1' }; }
});

export const timeColors = writable([
    { order: 'first', type: 'min', backgroundColor: '#7ade6c', dark: false, },
    { order: 'first', type: 'average', backgroundColor: '#77a7ef', dark: false, },
    { order: 'first', type: 'max', backgroundColor: '#e6807e', dark: false, },
    { order: 'overall', type: 'min', backgroundColor: '#74be4c', dark: false, },
    { order: 'overall', type: 'average', backgroundColor: '#7188cf', dark: false, },
    { order: 'overall', type: 'max', backgroundColor: '#e0615e', dark: false, },
    { order: 'last', type: 'min', backgroundColor: '#47ab39', dark: false, },
    { order: 'last', type: 'average', backgroundColor: '#5484cc', dark: false, },
    { order: 'last', type: 'max', backgroundColor: '#b35d5b', dark: false, },
    { order: 'first', type: 'min', backgroundColor: '#00dd00', dark: true, },
    { order: 'first', type: 'average', backgroundColor: '#0000dd', dark: true, },
    { order: 'first', type: 'max', backgroundColor: '#dd0000', dark: true, },
    { order: 'overall', type: 'min', backgroundColor: '#00cc00', dark: true, },
    { order: 'overall', type: 'average', backgroundColor: '#0000bb', dark: true, },
    { order: 'overall', type: 'max', backgroundColor: '#cc0000', dark: true, },
    { order: 'last', type: 'min', backgroundColor: '#00bb00', dark: true, },
    { order: 'last', type: 'average', backgroundColor: '#000099', dark: true, },
    { order: 'last', type: 'max', backgroundColor: '#bb0000', dark: true, },
]);

export const currentTimeColors = derived([isDarkMode, timeColors], ([$isDarkMode, $timeColors]) => {
    return $timeColors.filter(e => e.dark == $isDarkMode)
}, []);

export const currentChartMode = writable('byOrder');

export const chartBGColors = derived([currentChartMode, currentTimeColors], ([$currentChartMode, $currentTimeColors]) => {
    let bgColors = [];
    if ($currentChartMode == "byOrder") {
        bgColors.push($currentTimeColors.filter((e) => e.type == "min").map((e) => e.backgroundColor));
        bgColors.push($currentTimeColors.filter((e) => e.type == "average").map((e) => e.backgroundColor));
        bgColors.push($currentTimeColors.filter((e) => e.type == "max").map((e) => e.backgroundColor));
    } else {
        bgColors.push($currentTimeColors.filter((e) => e.order == "first").map((e) => e.backgroundColor));
        bgColors.push($currentTimeColors.filter((e) => e.order == "overall").map((e) => e.backgroundColor));
        bgColors.push($currentTimeColors.filter((e) => e.order == "last").map((e) => e.backgroundColor));
    }
    return bgColors;
}, []);