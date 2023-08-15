import React from 'react';
import PageTitleButton from 'components/atoms/common/PageTitleButton/PageTitleButton';
import JoinButton from 'components/atoms/consulting/JoinButton/JoinButton';
import CheckEquip from 'components/organisms/emergency/CheckEquip/CheckEquip';
import ConsultingParticipatePageLayout from 'components/layout/Page/ConsultingParticipatePageLayout/ConsultingParticipatePageLayout';
import ParticipateBox from 'components/organisms/consulting/ParticipateBox/ParticipateBox';
import { useLocation } from 'react-router-dom';
import requestState from 'recoil/consultingSession';
import { useRecoilState } from 'recoil';
import useMovePage from 'hooks/common/useMovePage';
import { createSubscribeConnectionApi, createSubscribeSessionIdApi } from 'utils/api/openVidu';
import { ISubscribeSessionInfo } from 'types/common/request';
import AreaTitle from 'components/atoms/common/AreaTitle/AreaTitle';
import ConsultingLottie from 'components/atoms/consulting/ConsultingLottie/ConsultingLottie';

function ConsultingParticipatePage() {
	const { consultingParticipateInfo } = useLocation().state;
	const { movePage } = useMovePage();
	const [, setRequest] = useRecoilState(requestState);

	// 세션 아이디로 openVidu 연결 토큰 생성
	const createConnection = async (sessionInfo: ISubscribeSessionInfo) => {
		try {
			if (sessionInfo) {
				const response = await createSubscribeConnectionApi(sessionInfo);
				if (response.status === 200) {
					const { token } = response.data;
					setRequest({ webRTCType: 1, token }); // 응급실에 대한 컨설팅이므로 1
					movePage('/consulting/video', null);
				}
			}
		} catch (error) {
			console.error(error);
		}
	};

	// 세션 아이디 생성
	const createSessionId = async () => {
		let sessionInfo: ISubscribeSessionInfo | null = null;
		try {
			const response = await createSubscribeSessionIdApi(consultingParticipateInfo.cid);

			if (response.status === 200) {
				sessionInfo = response.data as ISubscribeSessionInfo;
				createConnection(sessionInfo);
			}
		} catch (error) {
			console.error(error);
		}
	};

	const participate = () => {
		createSessionId();
	};

	return (
		<ConsultingParticipatePageLayout>
			{/* 이전으로 */}
			<PageTitleButton type="back" text="이전으로" />
			{/* area */}
			<AreaTitle title="1:1 화상 컨설팅 참여하기" url="#" />
			{/* lottie */}
			<ConsultingLottie />
			{/* 상품Detail box */}
			<ParticipateBox consultingParticipateInfo={consultingParticipateInfo} />
			{/* 장비확인 text */}
			<CheckEquip />
			{/* 참여하기 버튼 */}
			<JoinButton isActive handleClick={participate} />
		</ConsultingParticipatePageLayout>
	);
}

export default ConsultingParticipatePage;
