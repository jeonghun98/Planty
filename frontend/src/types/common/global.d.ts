// 캘린더의 선택된 날짜에 대한 타입
export type ValuePiece = Date | null;
export type Value = ValuePiece | [ValuePiece, ValuePiece];

/* 차트 관련 */
// 차트 data
export interface IChartData {
	labels: string[];
	datasets: Chart.ChartDataset<'line', number[], string>[];
}

// 차트의 막대 하나를 나타내는 데이터 셋.
export interface IPlantDataset {
	label: string;
	fill: boolean;
	tension: number;
	data: Array;
	borderColor: string;
	pointRadius: number;
}

// 막대 하나를 구성하는 식물 데이터들
export interface IPlantData {
	date: string;
	time: string;
	temp: number;
	humidity: number;
	soil: number;
}

// 홈 광고 배너
export interface IBanner {
	id: number;
	src: string;
}
