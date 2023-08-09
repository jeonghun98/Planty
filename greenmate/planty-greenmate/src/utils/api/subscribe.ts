import { instance } from './instance';

export const findAllSubscribeApi = async () => {
	const response = await instance.get('/subscribes');

	return response;
};

export const findSubscribeApi = async (sid: number) => {
	const response = await instance.get(`/subscribe/${sid}`);

	return response;
};

export const findAllBookingApi = async () => {
	const response = await instance.get('/bookings');

	return response;
};
